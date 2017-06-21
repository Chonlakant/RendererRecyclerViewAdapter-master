package com.github.vivchar.immutableadapter.items.profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vivchar.immutableadapter.R;

public class ProfileViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageView photo;
    public final ImageView bt_more;
    public final TextView text_name;


    public ProfileViewHolder(final View itemView) {
        super(itemView);

        photo = (ImageView) itemView.findViewById(R.id.photo);
        bt_more = (ImageView) itemView.findViewById(R.id.bt_more);
        text_name = (TextView) itemView.findViewById(R.id.text_name);

    }
}
