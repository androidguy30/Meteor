package com.kausthubhadhikari.transferwisetest.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kausthubhadhikari.transferwisetest.R;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 14/11/17.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentViewholder> {

    private Context context;
    private ArrayList<CommentsPojo> comments = new ArrayList<>();
    private AppUtils appUtils;

    public CommentAdapter(Context context, AppUtils appUtils) {
        this.context = context;
        this.appUtils = appUtils;
    }

    @Override
    public CommentViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item_layout, parent, false);
        CommentViewholder viewholder = new CommentViewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(CommentViewholder holder, int position) {
        Glide.with(context)
                .load(comments.get(position).user.avatarUrl)
                .into(holder.avataImage);
        holder.commentBody.setText(appUtils.getHTMLtoString(comments.get(position).body));
        holder.userName.setText(comments.get(position).user.name);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void updateData(ArrayList<CommentsPojo> data) {
        comments.clear();
        comments.addAll(data);
        notifyDataSetChanged();
    }

    public ArrayList<CommentsPojo> getData() {
        return comments;
    }

}
