package com.nullhuman.bmichecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class NutriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // trying to show the fuckn back button...
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // trying to show the fuckn back button...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutri);
    }
    public void showNutrient(View view) {
    }

    // experimental back button.. not working
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.onPause();
    }
}