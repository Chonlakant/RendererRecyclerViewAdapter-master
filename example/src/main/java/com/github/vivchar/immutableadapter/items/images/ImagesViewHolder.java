package com.github.vivchar.immutableadapter.items.images;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vivchar.immutableadapter.R;

public class ImagesViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageView photo_content;

    public ImagesViewHolder(final View itemView) {
        super(itemView);

        photo_content = (ImageView) itemView.findViewById(R.id.photo_content);


    }
}
