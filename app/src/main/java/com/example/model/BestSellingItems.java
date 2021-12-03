package com.example.model;

public class BestSellingItems {
    int itemID;
    String bestSellingName;

    public BestSellingItems(int itemID, String bestSellingName) {
        this.itemID = itemID;
        this.bestSellingName = bestSellingName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getBestSellingName() {
        return bestSellingName;
    }

    public void setBestSellingName(String bestSellingName) {
        this.bestSellingName = bestSellingName;
    }
}