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
            new prodC("maqloba", "launch", 19,"you will love our maqloba 5awa", R.drawable.maqluba),
            new prodC("lubia", "launch",20,"who eats lubia you sick fuck?", R.drawable.lubia),
            new prodC("cold shosmo", "Cold Drinks", 15,"ya7eeee bebarrred", R.drawable.coldsho),
            new prodC("shoqalata", "Cold Drinks", 13,"the fastest way to your girlfriends heart", R.drawable.shoqalata)


    };

    public static String getDetailsByName(String name){
        String n = "w";
        for (prodC product : products){
            if (product.getName().equals(name)) {
                n = product.getDetails();
                return n;
            }
        }
        return n;
    }

    public static int getImageByName(String name){
        int m = 0;
        for (prodC product : products){
            if (product.getName().equals(name)) {
                m = product.getImg();
                return m;
            }
        }
        return m;
    }

    public static int getCatLength(String cat){
        int L = 0;
        for (prodC product : products) {
            if (product.getCat().equals(cat))
                L++;
        }
        return L;
    }

}
