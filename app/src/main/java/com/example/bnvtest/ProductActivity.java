package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        String selected = intent.getStringExtra("SELECTED");

        TextView txv = findViewById(R.id.prod);
        txv.setText(selected);
    }
}