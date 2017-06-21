package com.github.vivchar.immutableadapter.items.text;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vivchar.immutableadapter.R;

public class TextViewHolder
        extends RecyclerView.ViewHolder {


    public final TextView text_content;


    public TextViewHolder(final View itemView) {
        super(itemView);

        text_content = (TextView) itemView.findViewById(R.id.text_content);

    }
}
