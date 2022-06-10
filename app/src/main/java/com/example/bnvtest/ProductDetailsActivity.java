package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bnvtest.model.MenuMockUp;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        RelativeLayout back = findViewById(R.id.back);
        TextView name = findViewById(R.id.detail), det = findViewById(R.id.det);

        Intent intent = getIntent();
        String selected = intent.getStringExtra("SELECTED");

        name.setText(selected);
        det.setText(MenuMockUp.getDetailsByName(selected));
        back.setBackground(getDrawable(MenuMockUp.getImageByName(selected)));



    }
}