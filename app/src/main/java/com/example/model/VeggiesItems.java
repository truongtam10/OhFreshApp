package com.example.model;

public class VeggiesItems {
    int veggiesID, backgroundID;
    String veggiesName;

    public VeggiesItems(int veggiesID, int backgroundID, String veggiesName) {
        this.veggiesID = veggiesID;
        this.backgroundID = backgroundID;
        this.veggiesName = veggiesName;
    }

    public VeggiesItems(int backgroundID) {
        this.backgroundID = backgroundID;
    }

    public int getVeggiesID() {
        return veggiesID;
    }

    public void setVeggiesID(int veggiesID) {
        this.veggiesID = veggiesID;
    }

    public int getBackgroundID() {
        return backgroundID;
    }

    public void setBackgroundID(int backgroundID) {
        this.backgroundID = backgroundID;
    }

    public String getVeggiesName() {
        return veggiesName;
    }

    public void setVeggiesName(String veggiesName) {
        this.veggiesName = veggiesName;
    }
}
