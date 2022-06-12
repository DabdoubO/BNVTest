package com.example.bnvtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragprofile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragprofile, container,false);
        MainActivity act = (MainActivity) getActivity();
        int user = act.getUser();
        TextView name = view.findViewById(R.id.textView);
        name.setText(user+"");
        return view;
    }
}
