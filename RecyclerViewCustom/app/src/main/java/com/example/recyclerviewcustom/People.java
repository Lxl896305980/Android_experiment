package com.example.recyclerviewcustom;

public class People {

    private String name;
    private int imageId;

    public People(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
