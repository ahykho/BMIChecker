package com.nullhuman.bmichecker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            height_value.setText(String.valueOf(progress));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    public void increaseAge(View view) {
        if (Integer.parseInt(age.getText().toString())  > 0 ){
            int age_value = Integer.parseInt(age.getText().toString()) + 1;
            age.setText(String.valueOf(age_value));
        }
    }

    public void decreaseAge(View view) {
        if (Integer.parseInt(age.getText().toString())  > 1 ){
            int age_value = Integer.parseInt(age.getText().toString()) - 1;
            age.setText(String.valueOf(age_value));
        }
    }

    public void increaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString())  > 0 ){
            int weight_value = Integer.parseInt(weight.getText().toString()) + 1;
            weight.setText(String.valueOf(weight_value));
        }
    }

    public void decreaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString())  > 1 ){
            int weight_value = Integer.parseInt(weight.getText().toString()) - 1;
            weight.setText(String.valueOf(weight_value));
        }
    }

    public void showResult(View view) {
        int get_age = Integer.parseInt(age.getText().toString());
        int weight_value = Integer.parseInt(weight.getText().toString());
        int get_height = Integer.parseInt(height_value.getText().toString())/ 100;

        int mbi = weight_value / get_height * get_height;

        showBMI(mbi);
        }

        private void showBMI(int mbi) {
            ViewGroup viewGroup = findViewById(android.R.id.content);
            View view = LayoutInflater.from(this).inflate(R.layout.custome_dialog, viewGroup, false);
            AppCompatButton ok = view.findViewById(R.id.ok);

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
}
//page seems ok..