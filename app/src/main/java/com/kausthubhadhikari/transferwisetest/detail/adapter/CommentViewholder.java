package com.kausthubhadhikari.transferwisetest.detail.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kausthubhadhikari.transferwisetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kausthubhadhikari on 14/11/17.
 */

public class CommentViewholder extends RecyclerView.ViewHolder {

    @BindView(R.id.userName)
    public AppCompatTextView userName;

    @BindView(R.id.commentBody)
    public AppCompatTextView commentBody;

    @BindView(R.id.avatar)
    public CircleImageView avataImage;

    public CommentViewholder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
