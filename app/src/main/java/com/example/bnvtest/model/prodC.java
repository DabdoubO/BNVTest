package com.example.bnvtest.model;

public class prodC {
    String name;
    String cat;
    float price;
    String details;
    int img;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public prodC(String name, String cat, float price, String details, int img) {
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.details = details;
        this.img = img;
    }

    public prodC(String name, String cat, float price, int img) {
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
