package domain.model;

import java.util.Date;

public class CreditCard {
    private int num;
    private int cvv;
    private Date expDate;
    private String name;
    
    public CreditCard(int num, Date expDate) {
        this.num = num;
        this.expDate = expDate;
    }

    public CreditCard(int num, int cvv, Date expDate, String name) {
        this.num = num;
        this.cvv = cvv;
        this.expDate = expDate;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
