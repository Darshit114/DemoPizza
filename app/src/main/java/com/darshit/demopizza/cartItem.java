package com.darshit.demopizza;

public class cartItem {
    String pname;
    int qty;

    public cartItem(String pname, int qty) {
        this.pname = pname;
        this.qty = qty;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
