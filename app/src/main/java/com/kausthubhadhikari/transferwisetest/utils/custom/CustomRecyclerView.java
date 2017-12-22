package com.kausthubhadhikari.transferwisetest.utils.custom;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */
public class CustomRecyclerView extends RecyclerView {
    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet, int def) {
        super(context, attributeSet, def);
    }

    @Override
    protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params, int index, int count) {
        LayoutManager layoutManager = getLayoutManager();
        if (getAdapter() != null && layoutManager instanceof GridLayoutManager) {
            GridLayoutAnimationController.AnimationParameters animParams =
                    (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;

            if (animParams == null) {
                animParams = new GridLayoutAnimationController.AnimationParameters();
                params.layoutAnimationParameters = animParams;
            }

            animParams.count = count;
            animParams.index = index;

            final int columns = ((GridLayoutManager) layoutManager).getSpanCount();
            animParams.columnsCount = columns;
            animParams.rowsCount = count / columns;

            final int invertedIndex = count - 1 - index;
            animParams.column = columns - 1 - (invertedIndex % columns);
            animParams.row = animParams.rowsCount - 1 - invertedIndex / columns;

        } else {
            super.attachLayoutAnimationParameters(child, params, index, count);
        }
    }

}
