package com.example.deepakrattan.recyclerviewdemo;

public class SingleRow {
    String title, desc;
    int image;

    public SingleRow(String title, String desc, int image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}
