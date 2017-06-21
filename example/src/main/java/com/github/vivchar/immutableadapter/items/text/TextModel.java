package com.github.vivchar.immutableadapter.items.text;

import android.support.annotation.NonNull;

import com.github.vivchar.immutableadapter.items.BaseItemModel;

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
public class TextModel
        implements BaseItemModel {

    public static final int TYPE = 1;
    private final int mID;
    @NonNull
    private final String mTitle;

    public TextModel(final int ID, @NonNull final String title) {
        mID = ID;
        mTitle = title;
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
    public String geText() {
        return mTitle;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TextModel that = (TextModel) o;

        if (mID != that.mID) {
            return false;
        }
        return mTitle.equals(that.mTitle);

    }

    @Override
    public int hashCode() {
        int result = mID;
        result = 31 * result + mTitle.hashCode();
        return result;
    }
}
