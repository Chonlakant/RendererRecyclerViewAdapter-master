package com.github.vivchar.immutableadapter.items.text;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
public class TextViewRenderer
        extends ViewRenderer<TextModel, TextViewHolder> {
    @NonNull
    private final Listener mListener;

    public TextViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final TextModel item, final TextViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final TextModel model, @NonNull final TextViewHolder holder) {
        holder.text_content.setText(model.geText());

    }

    @NonNull
    @Override
    public TextViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new TextViewHolder(inflate(R.layout.item_list_text, parent));
    }

    public interface Listener {
        void onTextClicked(@NonNull TextModel model);
    }
}
