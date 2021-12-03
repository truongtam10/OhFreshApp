package com.example.model;

public class Product {
    private int Thumb;
    private String Name, Price, Unit;

    public Product(int thumb, String name, String price, String unit) {
        Thumb = thumb;
        Name = name;
        Price = price;
        Unit = unit;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
