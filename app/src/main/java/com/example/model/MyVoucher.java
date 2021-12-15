package com.example.model;

import java.io.Serializable;

public class MyVoucher implements Serializable {
    private String voucherName;
    private String voucherValue;
    private String voucherDate;
    private String voucherID;

    public MyVoucher(String voucherName, String voucherValue, String voucherDate, String voucherID) {
        this.voucherName = voucherName;
        this.voucherValue = voucherValue;
        this.voucherDate = voucherDate;
        this.voucherID = voucherID;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public String getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(String voucherValue) {
        this.voucherValue = voucherValue;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }
}
