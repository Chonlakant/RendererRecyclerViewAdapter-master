package com.github.vivchar.immutableadapter.items.images;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.profile.ProfileModel;
import com.github.vivchar.immutableadapter.items.profile.ProfileViewHolder;
import com.github.vivchar.immutableadapter.widget.CircleTransform;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagesViewRenderer extends ViewRenderer<ImagesModel, ImagesViewHolder> {

    @NonNull
    private final Listener mListener;

    public ImagesViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final ImagesModel item, final ImagesViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final ImagesModel model, @NonNull final ImagesViewHolder holder) {

        Picasso.with(getContext())
                .load(model.getUrlAvatra())
                .into(holder.photo_content);

    }

    @NonNull
    @Override
    public ImagesViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesViewHolder(inflate(R.layout.item_list_photo, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesModel model);
    }

}
