package com.walton.retrofitexample;

public class Coins {
    private String id;
    private String name;
    private String image_128;
    public Coins(String id, String name, String image_128) {


        this.id = id;
        this.name = name;
        this.image_128 = image_128;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage_128() {
        return image_128;
    }
}

