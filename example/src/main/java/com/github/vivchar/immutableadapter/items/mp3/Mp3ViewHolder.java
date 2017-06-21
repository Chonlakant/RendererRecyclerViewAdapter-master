package com.github.vivchar.immutableadapter.items.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.vivchar.immutableadapter.R;

public class Mp3ViewHolder
        extends RecyclerView.ViewHolder {


    public final TextView text_mp3;


    public Mp3ViewHolder(final View itemView) {
        super(itemView);

        text_mp3 = (TextView) itemView.findViewById(R.id.text_mp3);

    }
}
