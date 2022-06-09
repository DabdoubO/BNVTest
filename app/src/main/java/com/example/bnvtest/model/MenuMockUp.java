package com.example.bnvtest.model;

import com.example.bnvtest.R;

public class MenuMockUp {


    public static final MenuC[] Menus = {
        new MenuC("Breakfast","ftoor", R.drawable.bf, "lstBF"),
        new MenuC("launch","8ada", R.drawable.lnsh, "lstLNSH"),
        new MenuC("Diner","3asha", R.drawable.diner, "lstDNR"),
        new MenuC("Hot Drinks","mashrobat sa7ina", R.drawable.hot, "lstHTDRNK"),
        new MenuC("Cold Drinks","mashrobat barida", R.drawable.cold, "lstCLDDRNK"),
        new MenuC("BEER","beeraaa", R.drawable.beer, "lstBEER"),
        new MenuC("Sheesha","argila", R.drawable.sheesha, "lstShsh")
    };

    public static final prodC[] products = {
            new prodC("maqloba", "launch", 19, R.drawable.maqluba),
            new prodC("lubia", "launch",20, R.drawable.lubia),
            new prodC("cold shosmo", "Cold Drinks", 15, R.drawable.coldsho),
            new prodC("shoqalata", "Cold Drinks", 13, R.drawable.shoqalata)


    };

    public static int getCatLength(String cat){
        int L = 0;
        for (prodC product : products) {
            if (product.getCat().equals(cat))
                L++;
        }
        return L;
    }

}
