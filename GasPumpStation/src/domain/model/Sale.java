package domain.model;

public class Sale {

    private CreditCard cc;
    private double amount;

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
