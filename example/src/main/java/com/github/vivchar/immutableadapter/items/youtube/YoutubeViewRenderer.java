package com.github.vivchar.immutableadapter.items.youtube;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.images.ImagesModel;
import com.github.vivchar.immutableadapter.items.images.ImagesViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YoutubeViewRenderer extends ViewRenderer<YoutubeModel, YoutubeViewHolder> {

    @NonNull
    private final Listener mListener;

    public YoutubeViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final YoutubeModel item, final YoutubeViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final YoutubeModel model, @NonNull final YoutubeViewHolder holder) {

        holder.txt_title_youtube.setText(model.getTitle());

        Picasso.with(getContext())
                .load(model.getCover())
                .into(holder.photo_youtube);

    }

    @NonNull
    @Override
    public YoutubeViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new YoutubeViewHolder(inflate(R.layout.item_list_youtube, parent));
    }

    public interface Listener {
        void onYoutubeClicked(@NonNull YoutubeModel model);
    }

}
