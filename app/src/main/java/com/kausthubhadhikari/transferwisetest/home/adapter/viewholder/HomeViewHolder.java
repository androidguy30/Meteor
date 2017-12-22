package com.kausthubhadhikari.transferwisetest.home.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kausthubhadhikari.transferwisetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    public ImageView imageView;

    public HomeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
