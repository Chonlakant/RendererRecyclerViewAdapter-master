package com.github.vivchar.immutableadapter.items.footer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.category.CategoryModel;
import com.github.vivchar.immutableadapter.items.category.CategoryViewRenderer;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.content.ContentViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
public class CommentViewRenderer
        extends ViewRenderer<CommentModel, CommentViewHolder> {
    @NonNull
    private final Listener mListener;

    public CommentViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final CommentModel item, final CommentViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final CommentModel model, @NonNull final CommentViewHolder holder) {
         holder.txt_like.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // mListener.onContentItemClicked(model);
            }
        });
        holder.bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCommentClicked(model);
            }
        });
    }

    @NonNull
    @Override
    public CommentViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new CommentViewHolder(inflate(R.layout.item_tap_comments, parent));
    }

    public interface Listener {
        void onCommentClicked(@NonNull CommentModel model);
    }
}
