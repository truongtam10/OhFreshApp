package com.example.model;

public class NewProductItems {
//    int productImage;
//    String productName, productPrice;
//
//    public NewProductItems(int productImage, String productName, String productPrice) {
//        this.productImage = productImage;
//        this.productName = productName;
//        this.productPrice = productPrice;
//    }
//
//    public int getProductImage() {
//        return productImage;
//    }
//
//    public void setProductImage(int productImage) {
//        this.productImage = productImage;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(String productPrice) {
//        this.productPrice = productPrice;
//    }
//}

    private int Thumb;
    private String Name, Price, Unit;

    public NewProductItems(int thumb, String name, String price, String unit) {
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
