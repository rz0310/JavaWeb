package com.bean;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Class clazz = Goods.class;
        try {
            Goods god = new Goods();
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(god,"zha");
            System.out.println(god);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
