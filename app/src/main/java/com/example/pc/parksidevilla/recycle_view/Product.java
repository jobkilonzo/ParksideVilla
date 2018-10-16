package com.example.pc.parksidevilla.recycle_view;

import android.widget.ImageView;

public class Product {
    private int imageView;
    private String title;
    private int cost;
    private String availability;
    public Product(int imageView,String title, int cost, String availability){
        this.imageView = imageView;
        this.title = title;
        this.cost = cost;
        this.availability = availability;
    }
    public int getImageView() {
        return imageView;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public String getAvailability() {
        return availability;
    }
}
