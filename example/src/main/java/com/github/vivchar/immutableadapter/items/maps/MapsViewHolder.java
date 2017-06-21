package com.github.vivchar.immutableadapter.items.maps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vivchar.immutableadapter.R;

public class MapsViewHolder
        extends RecyclerView.ViewHolder {



    public final TextView txt_maps;


    public MapsViewHolder(final View itemView) {
        super(itemView);

        txt_maps = (TextView) itemView.findViewById(R.id.txt_maps);

    }
}
