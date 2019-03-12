package com.bean;

public class Bill {
    private String id;
    private String status;
    private double money;
    private String date;
    private String goodsName;
    private int goodsNum;
    private double goodsPrice;

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", money=" + money +
                ", date='" + date + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNum=" + goodsNum +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
