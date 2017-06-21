package com.github.vivchar.immutableadapter.items.viedo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.images.ImagesModel;
import com.github.vivchar.immutableadapter.items.images.ImagesViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoViewRenderer extends ViewRenderer<ViedoModel, VideoViewHolder> {

    @NonNull
    private final Listener mListener;

    public VideoViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final ViedoModel item, final VideoViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final ViedoModel model, @NonNull final VideoViewHolder holder) {

//        Picasso.with(getContext())
//                .load(model.getUrlViedo())
//                .into(holder.img_play);

        holder.txt_title_video.setText(model.getTitle());
        holder.myvideoView.setVideoPath(model.getUrlViedo());

        //play pause stop

        MediaController mediaController = new MediaController(getContext());
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(holder.myvideoView);
        holder.myvideoView.setMediaController(mediaController);


    }

    @NonNull
    @Override
    public VideoViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new VideoViewHolder(inflate(R.layout.item_list_video, parent));
    }

    public interface Listener {
        void onPlayClicked(@NonNull ViedoModel model);
    }

}
