package com.example.dhiviya.dhivya.list;


import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.dhiviya.dhivya.R;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private List<String> imageList;
    private FragmentActivity activity;

    public ListAdapter(FragmentActivity activity, List<String> imageList) {
        this.imageList = imageList;
        this.activity = activity;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Glide.with(activity).load(imageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
