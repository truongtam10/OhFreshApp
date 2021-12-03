package com.example.model;

public class PaymentMethod {
    private String paymentName;
    private int paymentIcon;
    private String paymentDescription;

    public PaymentMethod(String paymentName, int paymentIcon, String paymentDescription) {
        this.paymentName = paymentName;
        this.paymentIcon = paymentIcon;
        this.paymentDescription = paymentDescription;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public int getPaymentIcon() {
        return paymentIcon;
    }

    public void setPaymentIcon(int paymentIcon) {
        this.paymentIcon = paymentIcon;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
}
