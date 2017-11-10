package com.example.dhiviya.dhivya.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dhiviya.dhivya.R;


public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public ListViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }
}
