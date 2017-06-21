package com.github.vivchar.immutableadapter.items.profile;

import android.support.annotation.NonNull;

import com.github.vivchar.immutableadapter.items.BaseItemModel;

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
public class ProfileModel implements BaseItemModel {

    public static final int TYPE = 9;
    private final int mID;
    private String name;
    private String urlAvatra;


    public ProfileModel(int mID, String name, String urlAvatra) {
        this.mID = mID;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlAvatra() {
        return urlAvatra;
    }

    public void setUrlAvatra(String urlAvatra) {
        this.urlAvatra = urlAvatra;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ProfileModel that = (ProfileModel) o;

        if (mID != that.mID) {
            return false;
        }
        return name.equals(that.name);

    }


}
