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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bnvtest.model.MenuC;
import com.example.bnvtest.model.MenuMockUp;

import java.util.ArrayList;

public class fragmenu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenu, container,false);
        RecyclerView recycler = view.findViewById(R.id.menu_recycler);

        String[] captions = new String[MenuMockUp.Menus.length];
        int[] ids = new int[MenuMockUp.Menus.length];


        for(int i = 0; i<captions.length;i++){
            captions[i] = MenuMockUp.Menus[i].getName();
            ids[i] = MenuMockUp.Menus[i].getImg();
        }

        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        CardAdapter LSTAdapter = new CardAdapter(captions,ids);
        recycler.setAdapter(LSTAdapter);
        return view;
    }
}
