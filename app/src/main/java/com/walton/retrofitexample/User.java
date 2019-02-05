package com.walton.retrofitexample;
public class User {

    private String name;
    private String proprietorName;
    private String presentAddress;
    private String mobilePhone;
    private String shopCategory;





    public User(String name,  String proprietorName,String presentAddress, String mobilePhone,String shopCategory) {
        this.name = name;
        this.proprietorName = proprietorName;
        this.presentAddress = presentAddress;
        this.mobilePhone = mobilePhone;
        this.shopCategory = shopCategory;


    }

    public String getName() {
        return name;
    }

    public String getProprietorName() {
        return proprietorName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getShopCategory() {
        return shopCategory;
    }



}