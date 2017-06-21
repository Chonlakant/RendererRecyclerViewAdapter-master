package com.github.vivchar.immutableadapter.items.mp3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.file.fileModel;
import com.github.vivchar.immutableadapter.items.file.fileViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class Mp3ViewRenderer extends ViewRenderer<Mp3Model, Mp3ViewHolder> {

    @NonNull
    private final Listener mListener;

    public Mp3ViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final Mp3Model item, final Mp3ViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final Mp3Model model, @NonNull final Mp3ViewHolder holder) {

        holder.text_mp3.setText(model.getTitle());
      //  holder.text_fifle.setText(model.getTitle());


    }

    @NonNull
    @Override
    public Mp3ViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new Mp3ViewHolder(inflate(R.layout.item_list_mp3, parent));
    }

    public interface Listener {
        void onPlayClicked(@NonNull Mp3Model model);
    }

}
