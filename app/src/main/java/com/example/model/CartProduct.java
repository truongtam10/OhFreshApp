package com.example.model;

public class CartProduct {
    private int productThumb;
    private int productNumber;
    private String productName;
    private double productPrice;
    private double productWeight;

    public CartProduct(int productThumb, String productName, double productPrice, double productWeight, int productNumber) {
        this.productThumb = productThumb;
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }
}