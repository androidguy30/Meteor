package com.kausthubhadhikari.transferwisetest.utils.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

import com.kausthubhadhikari.transferwisetest.R;

import java.lang.reflect.Field;

/**
 * Created by kausthubhadhikari on 07/11/17.
 */

public class CollapsingLogoToolbarLayout extends CollapsingToolbarLayout {

    private int mLogoViewId;
    private int mExpandedViewOffset;
    private int mCollapsedViewOffset;

    private View mLogoView;
    private WindowInsetsCompat mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mLogoOffsetChangeListener;

    public CollapsingLogoToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingLogoToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollapsingLogoToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CollapsingLogoToolbarLayout);
        mLogoViewId = a.getResourceId(R.styleable.CollapsingLogoToolbarLayout_logoViewId, -1);
        mExpandedViewOffset = a.getDimensionPixelOffset(R.styleable.CollapsingLogoToolbarLayout_expandedViewOffset, 0);
        mCollapsedViewOffset = a.getDimensionPixelOffset(R.styleable.CollapsingLogoToolbarLayout_collapsedViewOffset, 0);
        a.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (mLogoOffsetChangeListener == null) {
                mLogoOffsetChangeListener = new LogoOffsetUpdateListener();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.mLogoOffsetChangeListener);
        }
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        ViewParent parent = this.getParent();
        if (this.mLogoOffsetChangeListener != null && parent instanceof AppBarLayout) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(this.mLogoOffsetChangeListener);
        }

        super.onDetachedFromWindow();
    }

    protected void onExpansionFractionUpdate(float fraction) {
        ensureLogoView();
        mLogoView.setTranslationY(mExpandedViewOffset + (mCollapsedViewOffset - mExpandedViewOffset) * fraction);
        if (Build.VERSION.SDK_INT >= 21) {
            mLogoView.setTranslationZ(mExpandedViewOffset + (mCollapsedViewOffset - mExpandedViewOffset) * fraction);
        }
    }

    private void ensureLogoView() {
        if (mLogoView == null) {
            mLogoView = findViewById(mLogoViewId);
        }
    }

    private void ensureWindowInset() {
        if (mLastInsets == null) {
            try {
                Field field = CollapsingToolbarLayout.class.getDeclaredField("mLastInsets");
                field.setAccessible(true);
                this.mLastInsets = (WindowInsetsCompat) field.get(this);
            } catch (NoSuchFieldException ignored) {
            } catch (IllegalAccessException ignored) {
            }
        }
    }

    private class LogoOffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        private LogoOffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout layout, int verticalOffset) {
            ensureWindowInset();
            int insetTop = CollapsingLogoToolbarLayout.this.mLastInsets != null ? CollapsingLogoToolbarLayout.this.mLastInsets.getSystemWindowInsetTop() : 0;
            int expandRange = CollapsingLogoToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingLogoToolbarLayout.this) - insetTop;
            CollapsingLogoToolbarLayout.this.onExpansionFractionUpdate((float) Math.abs(verticalOffset) / (float) expandRange);
        }
    }
}