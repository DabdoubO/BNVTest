package com.example.bnvtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bnvtest.model.MenuC;
import com.example.bnvtest.model.MenuMockUp;

import java.util.ArrayList;

public class fragmenu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenu, container,false);
        ListView lstm = view.findViewById(R.id.LSTMENU);
        MenuMockUp database = new MenuMockUp();

        ArrayList<MenuC> result = database.getMenus();

//        ArrayAdapter<MenuC> LSTAdapter = new ArrayAdapter<MenuC>(this, android.R.layout.simple_spinner_dropdown_item,result);
//        lstm.setAdapter(LSTAdapter);
        return view;
    }
}
