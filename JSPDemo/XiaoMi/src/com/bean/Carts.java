package com.bean;

public class Carts {
    private int id;
    private String name;
    private String img;
    private int num;
    private double price;
    private String version;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String vision) {
        this.version = vision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        Carts carts = (Carts) object;
        if(this.id == carts.getId()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();
    }
}
