package com.github.vivchar.immutableadapter.items.mp3;

import com.github.vivchar.immutableadapter.items.BaseItemModel;

public class Mp3Model implements BaseItemModel {

    public static final int TYPE = 5;
    private final int mID;
    private String urlfifle;
    private String title;


    public Mp3Model(int mID, String urlfifle, String title) {
        this.mID = mID;

        this.urlfifle = urlfifle;
        this.title = title;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlfifle() {
        return urlfifle;
    }

    public void setUrlfifle(String urlfifle) {
        this.urlfifle = urlfifle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
