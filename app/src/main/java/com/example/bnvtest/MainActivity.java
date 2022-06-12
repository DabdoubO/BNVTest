package com.example.bnvtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    int user = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView BNV = findViewById(R.id.botNav);
        BNV.setOnNavigationItemSelectedListener(navListener);
        BNV.setSelectedItemId(R.id.navHome);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmintContainer,new fraghome()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFrag = null;

                    switch (item.getItemId()){
                        case R.id.navMenu:
                            selectedFrag = new fragmenu();
                            break;
                        case R.id.navCart:
                            selectedFrag = new fragcart();
                            break;
                        case R.id.navHome:
                            selectedFrag = new fraghome();
                            break;
                        case R.id.navNotif:
                            selectedFrag = new fragnotif();
                            break;
                        case R.id.navProfile:
                            selectedFrag = new fragprofile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmintContainer,selectedFrag).commit();
                    return true;
                }
            };
    public int getUser(){
        return user;
    }
}