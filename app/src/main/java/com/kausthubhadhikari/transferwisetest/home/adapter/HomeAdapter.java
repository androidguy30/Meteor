package com.kausthubhadhikari.transferwisetest.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.kausthubhadhikari.transferwisetest.R;
import com.kausthubhadhikari.transferwisetest.home.adapter.viewholder.HomeViewHolder;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private Context context;
    private ArrayList<HomePojo> data = new ArrayList<>();
    private OnClickListener clickListener;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout, parent, false);
        HomeViewHolder viewHolder = new HomeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        Glide.with(context)
                .load(data.get(position).images.normal)
                .transition(GenericTransitionOptions.with((dataSource, isFirstResource) -> new DrawableCrossFadeTransition(300, true)))
                .into(holder.imageView);

        holder.itemView.setOnClickListener(view -> clickListener.OnClick(position));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public HomePojo getDataAtPosition(int position) {
        return data.get(position);
    }

    public void updateData(ArrayList<HomePojo> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void OnClick(int position);
    }

    public ArrayList<HomePojo> getData() {
        return data;
    }

}
