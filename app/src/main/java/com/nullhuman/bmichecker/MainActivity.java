package com.nullhuman.bmichecker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView age;
    private TextView weight;
    private AppCompatSeekBar seekBar;
    private TextView height_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(listener);
        height_value = findViewById(R.id.height_value);

    }
    // Seekbar coding for Height //
    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            height_value.setText(String.valueOf(String.format("%d Cm", progress)));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    // Code increasing Age by clicks
    public void increaseAge(View view) {
        if (Integer.parseInt(age.getText().toString())  > 0 ){
            int age_value = Integer.parseInt(age.getText().toString()) + 1;
            age.setText(String.valueOf(age_value));
        }
    }
    // Code decreasing Age by clicks
    public void decreaseAge(View view) {
        if (Integer.parseInt(age.getText().toString())  > 1 ){
            int age_value = Integer.parseInt(age.getText().toString()) - 1;
            age.setText(String.valueOf(age_value));
        }
    }
    // Code increasing weight by click
    public void increaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString())  > 0 ){
            int weight_value = Integer.parseInt(weight.getText().toString()) + 1;
            weight.setText(String.valueOf(weight_value));
        }
    }
    // Code decreasing weight by click
    public void decreaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString())  > 1 ){
            int weight_value = Integer.parseInt(weight.getText().toString()) - 1;
            weight.setText(String.valueOf(weight_value));
        }
    }
    // calculating input clicks
    public void showResult(View view) {
        int get_age = Integer.parseInt(age.getText().toString());
        double weight_value = Integer.parseInt(weight.getText().toString());
        double get_height = (double)seekBar.getProgress()/ 100;

        double bmi = weight_value / (get_height * get_height);

        showBMI(bmi);
        }
        // Showing results based on calculation
        private void showBMI(double bmi) {

        if (bmi < 18.5){
            showCustomDialog(R.drawable.underweight, "UnderWeight", "take a Senzu Bean!!!");
        }else if(bmi > 18.5 && bmi < 24.9){
            showCustomDialog(R.drawable.normalweight, "NormalWeight", "Keep your head up like that!!!");
        }else{
            showCustomDialog(R.drawable.overweight, "OverWeight", "..back to the training chamber lazy fatass");
        }

    }
    // Setter for custom
    private void showCustomDialog(int id, String title, String tip) {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View view = LayoutInflater.from(this).inflate(R.layout.custome_dialog, viewGroup, false);
        AppCompatButton ok = view.findViewById(R.id.ok);
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView result_title = view.findViewById(R.id.result_title);
        TextView tips = view.findViewById(R.id.tips);
        imageView.setImageResource(id);
        result_title.setText(title);
        tips.setText(tip);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    // new checked working page-switch |main -to- Nutri && main -to- Sport|
    public void showNutrient(View view) {
        setContentView(R.layout.activity_nutri);
    }

    public void showSport(View view) {
        setContentView(R.layout.activity_sport);
    }
}

//page seems ok.. almost