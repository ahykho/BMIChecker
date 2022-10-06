package com.nullhuman.bmichecker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView age;
    private TextView weight;
    private AppCompatSeekBar seekBar;
    private TextView height_value;
    // .. switch female-male
    boolean switch_status;
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;
    SwitchCompat switchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            Button button;
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // age, weight, height_value, seekBar && ..
            age = findViewById(R.id.age);
            weight = findViewById(R.id.weight);
            seekBar = findViewById(R.id.seek_bar);
            height_value = findViewById(R.id.height_value);
            seekBar.setOnSeekBarChangeListener(listener);

            // .. switch female-male
            switchButton = findViewById(R.id.gender_switch);
            String MY_PREF = "switch_prefs";
            myPreferences = getSharedPreferences(MY_PREF,MODE_PRIVATE);
            myEditor = getSharedPreferences(MY_PREF,MODE_PRIVATE).edit();
            String SWITCH_STATUS = "switch_status";
            switch_status = myPreferences.getBoolean(SWITCH_STATUS, false);
            switchButton.setChecked(switch_status);
            switchButton.setOnCheckedChangeListener((compoundButton, b) -> {});

            // switch to Nutrient Activity
            button = findViewById(R.id.nutrient_button);
            button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NutriActivity.class)));

            // switch to Sport Activity
            button = findViewById(R.id.sport_button);
            button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SportActivity.class)));
            }

    // Seekbar coding for Height //
    private final SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height_value.setText(String.format("%d Cm", progress));
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


    // calculating input clicks && differ via gender && age not defined yet!!!
    public void showResult(View view) {
            int get_age = Integer.parseInt(age.getText().toString());
            double weight_value = Integer.parseInt(weight.getText().toString());
            double get_height = (double)seekBar.getProgress()/ 100;

            // BMI - Female
            double bmiF = weight_value / (get_height * get_height);
            // BMI - Male
            double bmiM = weight_value / (get_height * get_height);
            // differ calculation via gender_switch
            if (switch_status){
                showBMImale(bmiM);
            }else{
                showBMIfemale(bmiF);
            }
            }


    // Showing results based on calculation  / Male
    private void showBMImale(double bmiM) {
            if (bmiM < 18.5){
                showCustomDialog(R.drawable.underweight, "UnderWeight", "take a Senzu Bean!!!");
            }else if(bmiM > 18.5 && bmiM < 24.9){
                showCustomDialog(R.drawable.normalweight, "NormalWeight", "Keep your head up like that!!!");
            }else{
                showCustomDialog(R.drawable.overweight, "OverWeight", "..back to the training chamber lazy fatass");
            }
        }


    // Showing results based on calculation  / Female
    private void showBMIfemale(double bmiF) {
            if (bmiF < 17.5){
                showCustomDialog(R.drawable.underweight, "UnderWeight", "take a Senzu Bean!!!");
            }else if(bmiF > 17.5 && bmiF < 24.0){
                showCustomDialog(R.drawable.normalweight, "NormalWeight", "Keep your head up like that!!!");
            }else{
                showCustomDialog(R.drawable.overweight, "OverWeight", "..back to the training chamber lazy fatass");
            }
        }


    // Setter for custom dialog aka Result, as alert style
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

            ok.setOnClickListener(v -> alertDialog.dismiss());

    }
}
//page seems ok.. almost