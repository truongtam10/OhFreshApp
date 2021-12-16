package com.example.model;

import java.io.Serializable;

public class Voucher implements Serializable {

    private String AmountDiscount;
    private String DateExpiration;

    public Voucher(String amountDiscount, String dateExpiration) {
        AmountDiscount = amountDiscount;
        DateExpiration = dateExpiration;
    }

    public String getAmountDiscount() {
        return AmountDiscount;
    }

    public void setAmountDiscount(String amountDiscount) {
        AmountDiscount = amountDiscount;
    }

    public String getDateExpiration() {
        return DateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        DateExpiration = dateExpiration;
    }
}
