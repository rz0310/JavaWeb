package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    int id=0;
    public Test(int id){
        this.id=id;

    }
    public static void main(String[] args) {
        jsonOne();
    }
    public static void jsonOne(){
//      创建JSONObject对象
        JSONObject jsonObject = new JSONObject();
        List<Student> list = new ArrayList<>();
        
        list.add(new Student(1,"任静"));
        list.add(new Student(2,"小仙女"));
        list.add(new Student(3,"哈哈"));

        jsonObject.put("name","任静");
        jsonObject.put("age",21);
        jsonObject.put("major",new String[]{"软件","即可"});
        jsonObject.put("obj",new Test(5));
        jsonObject.put("list",list);
//        System.out.println(jsonObject.getInt("age"));
//        System.out.println(jsonObject.toString());

//        JSONObject major1 = jsonObject.getJSONObject("major");
//
//        JSONArray major = new JSONArray(major1);
//        System.out.println(major);
//        for (int i = 0; i < major.size(); i++) {
//            System.out.println(major.get(i));
//        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
        }
    }
}
