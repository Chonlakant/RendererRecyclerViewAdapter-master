package com.github.vivchar.immutableadapter.items.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.github.vivchar.immutableadapter.R;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.footer.CommentModel;
import com.github.vivchar.immutableadapter.items.footer.CommentViewHolder;
import com.github.vivchar.immutableadapter.widget.CircleTransform;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileViewRenderer extends ViewRenderer<ProfileModel, ProfileViewHolder> {

    @NonNull
    private final Listener mListener;
    public static OnPhotoClick mPhotoClick;
    public ProfileViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final ProfileModel item, final ProfileViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {
            if (key.equals(ContentModel.KEY_NAME)) {

                // holder.mTextView.setText(item.getName());
            }
        }
    }

    @Override
    public void bindView(@NonNull final ProfileModel model, @NonNull final ProfileViewHolder holder) {
        holder.text_name.setText(model.getName());


        Picasso.with(getContext())
                .load(model.getUrlAvatra())
                .resize(80, 80)
                .transform(new CircleTransform())
                .into(holder.photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // mListener.onContentItemClicked(model);
            }
        });
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onProfileClicked(model);
            }
        });
    }

    @NonNull
    @Override
    public ProfileViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ProfileViewHolder(inflate(R.layout.item_profile, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ProfileModel model);
    }

    public interface OnPhotoClick {
        public void onPhotoClick(View view, int position);
    }

    public void SetOnPhotoClick(final OnPhotoClick mPhotoClick) {
        this.mPhotoClick = mPhotoClick;
    }
}
