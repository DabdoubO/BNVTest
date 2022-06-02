package com.example.bnvtest.model;

import com.example.bnvtest.R;

import java.util.ArrayList;

public class MenuMockUp {

    private ArrayList<MenuC> Menus = new ArrayList<>();

    public MenuMockUp(){
        Menus.add(new MenuC("Breakfast","ftoor", R.drawable.bf, "lstBF"));
        Menus.add(new MenuC("launch","8ada", R.drawable.lnsh, "lstLNSH"));
        Menus.add(new MenuC("Diner","3asha", R.drawable.diner, "lstDNR"));
        Menus.add(new MenuC("Hot Drinks","mashrobat sa7ina", R.drawable.hot, "lstHTDRNK"));
        Menus.add(new MenuC("Cold Drinks","mashrobat barida", R.drawable.cold, "lstCLDDRNK"));
        Menus.add(new MenuC("BEER","beeraaa", R.drawable.beer, "lstBEER"));
        Menus.add(new MenuC("Sheesha","argila", R.drawable.sheesha, "lstShsh"));
    }

    public ArrayList<MenuC> getMenus (){

        ArrayList<MenuC> result = new ArrayList<>();

        for (MenuC m : Menus){
                result.add(m);
        }
        return result;
    }
}
