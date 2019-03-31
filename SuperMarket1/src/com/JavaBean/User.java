package com.JavaBean;

public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_pwd2;
    private String user_sex;
    private String user_birth;
    private String user_tel;
    private String user_add;
    private String user_type;

    private String user_time;
    private String user_age;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_time() {
        return user_time;
    }

    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_add() {
        return user_add;
    }

    public void setUser_add(String user_add) {
        this.user_add = user_add;
    }

    public String getUser_pwd2() {
        return user_pwd2;
    }

    public void setUser_pwd2(String user_pwd2) {
        this.user_pwd2 = user_pwd2;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_pwd2='" + user_pwd2 + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_birth='" + user_birth + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_add='" + user_add + '\'' +
                ", user_type='" + user_type + '\'' +
                ", user_time='" + user_time + '\'' +
                ", user_age='" + user_age + '\'' +
                '}';
    }
}
