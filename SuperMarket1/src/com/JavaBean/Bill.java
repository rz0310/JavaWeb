package com.JavaBean;

public class Bill {
    private int bill_id;
    private String bill_name;
    private String bill_unit;
    private String bill_amount;
    private String bill_money;
    private String bill_provider;
    private String bill_isPay;
    private String bill_time;

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getBill_unit() {
        return bill_unit;
    }

    public void setBill_unit(String bill_unit) {
        this.bill_unit = bill_unit;
    }

    public String getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(String bill_amount) {
        this.bill_amount = bill_amount;
    }

    public String getBill_provider() {
        return bill_provider;
    }

    public void setBill_provider(String bill_provider) {
        this.bill_provider = bill_provider;
    }

    public String getBill_money() {
        return bill_money;
    }

    public void setBill_money(String bill_money) {
        this.bill_money = bill_money;
    }

    public String getBill_isPay() {
        return bill_isPay;
    }

    public void setBill_isPay(String bill_isPay) {
        this.bill_isPay = bill_isPay;
    }

    public String getBill_time() {
        return bill_time;
    }

    public void setBill_time(String bill_time) {
        this.bill_time = bill_time;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id=" + bill_id +
                ", bill_name='" + bill_name + '\'' +
                ", bill_unit='" + bill_unit + '\'' +
                ", bill_amount='" + bill_amount + '\'' +
                ", bill_provider='" + bill_provider + '\'' +
                ", bill_money='" + bill_money + '\'' +
                ", bill_isPay='" + bill_isPay + '\'' +
                ", bill_time='" + bill_time + '\'' +
                '}';
    }
}