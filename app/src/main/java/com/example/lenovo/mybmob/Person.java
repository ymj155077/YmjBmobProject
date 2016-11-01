package com.example.lenovo.mybmob;


import cn.bmob.v3.BmobObject;

/**
 * Created by lenovo on 2016/10/31.
 */
public class Person extends BmobObject {
    private String name;
    private String address;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

}

