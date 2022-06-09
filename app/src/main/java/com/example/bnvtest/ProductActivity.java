package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bnvtest.model.MenuMockUp;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        RecyclerView recycler = findViewById(R.id.products);

        Intent intent = getIntent();
        String selected = intent.getStringExtra("SELECTED");

        TextView txv = findViewById(R.id.prod);
        txv.setText(selected);

        String[] captions = new String[MenuMockUp.getCatLength(selected)];
        int[] imgs = new int[MenuMockUp.getCatLength(selected)];


        for(int i = 0, j = 0; i<MenuMockUp.products.length;i++){
            if (MenuMockUp.products[i].getCat().equals(selected)) {
                captions[j] = MenuMockUp.products[i].getName();
                imgs[j] = MenuMockUp.products[i].getImg();
                j++;
            }
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter adapter = new CardAdapter(captions,imgs);
        recycler.setAdapter(adapter);
    }
}