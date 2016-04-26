package com.pumpmachine.gaspumpstation;
/**
 * Created by twinklesharma on 4/23/16.
 */
public class Sale {


    CreditCard cc;
    double amount;

    public CreditCard getCreditCard() {
        return cc;
    }

    public void setCreditCard(CreditCard cc) {
        this.cc = cc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
