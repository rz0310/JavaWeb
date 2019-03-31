package com.JavaBean;

public class Provider {
    private int pro_id;
    private String pro_name;
    private String pro_conn;
    private String pro_tel;
    private String pro_add;
    private String pro_fax;
    private String pro_desc;
    private String pro_time;

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_conn() {
        return pro_conn;
    }

    public void setPro_conn(String pro_conn) {
        this.pro_conn = pro_conn;
    }

    public String getPro_tel() {
        return pro_tel;
    }

    public void setPro_tel(String pro_tel) {
        this.pro_tel = pro_tel;
    }

    public String getPro_fax() {
        return pro_fax;
    }

    public void setPro_fax(String pro_fax) {
        this.pro_fax = pro_fax;
    }

    public String getPro_time() {
        return pro_time;
    }

    public void setPro_time(String pro_time) {
        this.pro_time = pro_time;
    }

    public String getPro_add() {
        return pro_add;
    }

    public void setPro_add(String pro_add) {
        this.pro_add = pro_add;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_conn='" + pro_conn + '\'' +
                ", pro_tel='" + pro_tel + '\'' +
                ", pro_add='" + pro_add + '\'' +
                ", pro_fax='" + pro_fax + '\'' +
                ", pro_time='" + pro_time + '\'' +
                ", pro_desc='" + pro_desc + '\'' +
                '}';
    }
}
