package com.github.vivchar.immutableadapter.items.soundcloud;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.text.TextModel;
import com.github.vivchar.immutableadapter.items.text.TextViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
public class SoundCloudViewRenderer
        extends ViewRenderer<SoundCloudModel, SoundCloudViewHolder> {
    @NonNull
    private final Listener mListener;

    public SoundCloudViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final SoundCloudModel item, final SoundCloudViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final SoundCloudModel model, @NonNull final SoundCloudViewHolder holder) {
        holder.text_soundcloud.setText(model.geText());

    }

    @NonNull
    @Override
    public SoundCloudViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new SoundCloudViewHolder(inflate(R.layout.item_list_soundcloud, parent));
    }

    public interface Listener {
        void onSoundCloudClicked(@NonNull SoundCloudModel model);
    }
}
