package com.example.model;

import java.io.Serializable;

public class Voucher implements Serializable {

    private int AmountDiscount;
    private String DateExpiration;

    public Voucher(int amountDiscount, String dateExpiration) {
        AmountDiscount = amountDiscount;
        DateExpiration = dateExpiration;
    }

    public int getAmountDiscount() {
        return AmountDiscount;
    }

    public void setAmountDiscount(int amountDiscount) {
        AmountDiscount = amountDiscount;
    }

    public String getDateExpiration() {
        return DateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        DateExpiration = dateExpiration;
    }
}
