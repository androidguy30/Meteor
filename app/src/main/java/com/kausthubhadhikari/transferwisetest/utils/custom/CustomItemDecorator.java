package com.kausthubhadhikari.transferwisetest.utils.custom;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */

public class CustomItemDecorator extends RecyclerView.ItemDecoration {

    private int size;

    public CustomItemDecorator(int size) {
        this.size = size;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) % 2 == 0) {
            outRect.right = size;
            outRect.top = size;
        } else {
            outRect.top = size;
        }

        if (parent.getAdapter().getItemCount() - 1 == parent.getChildAdapterPosition(view) || parent.getAdapter().getItemCount() - 2 == parent.getChildAdapterPosition(view)) {
            outRect.bottom = size;
        }
    }

}
