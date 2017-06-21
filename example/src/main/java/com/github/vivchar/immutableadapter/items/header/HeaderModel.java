package com.github.vivchar.immutableadapter.items.header;

import android.support.annotation.NonNull;

import com.github.vivchar.immutableadapter.items.BaseItemModel;

/**
 * Created by Vivchar Vitaly on 3/6/17.
 */
public class HeaderModel
        implements BaseItemModel {

    public static final int TYPE = 0;
    private final int mID;

    @NonNull
    private final String mName;

     String avatar;

    public HeaderModel(final int ID, @NonNull final String name, String avatar) {
        mID = ID;
        mName = name;
        avatar = avatar;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @NonNull
    public String getName() {
        return mName;
    }


}
