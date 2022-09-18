package com.nullhuman.bmichecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class NutriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutri);
    }
    public void showNutrient(View view) {
    }

    // experimental back button.. not working
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.onPause();
    }
}

