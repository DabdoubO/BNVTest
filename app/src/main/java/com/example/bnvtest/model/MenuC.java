package com.example.bnvtest.model;

import android.graphics.drawable.Drawable;

public class MenuC {
    private String Name;
    private String Description;
    private int img;
    private String NavTo;

    public MenuC(String name, String description, int img, String navTo) {
        Name = name;
        Description = description;
        img = img;
        NavTo = navTo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        img = img;
    }

    public String getNavTo() {
        return NavTo;
    }

    public void setNavTo(String navTo) {
        NavTo = navTo;
    }
}
