package com.nullhuman.bmichecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class NutriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutri);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}