package com.github.vivchar.immutableadapter.items.images;

import com.github.vivchar.immutableadapter.items.BaseItemModel;

public class ImagesModel implements BaseItemModel {

    public static final int TYPE = 2;
    private final int mID;
    private String urlAvatra;


    public ImagesModel(int mID, String urlAvatra) {
        this.mID = mID;

        this.urlAvatra = urlAvatra;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlAvatra() {
        return urlAvatra;
    }

    public void setUrlAvatra(String urlAvatra) {
        this.urlAvatra = urlAvatra;
    }



}
