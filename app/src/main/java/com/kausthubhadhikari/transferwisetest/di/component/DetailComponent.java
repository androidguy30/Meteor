package com.kausthubhadhikari.transferwisetest.di.component;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.kausthubhadhikari.transferwisetest.detail.adapter.CommentAdapter;
import com.kausthubhadhikari.transferwisetest.detail.presenter.DetailPresenter;
import com.kausthubhadhikari.transferwisetest.detail.view.DetailActivity;
import com.kausthubhadhikari.transferwisetest.di.module.DetailModule;
import com.kausthubhadhikari.transferwisetest.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@ActivityScope
@Component(modules = {DetailModule.class}, dependencies = {AppComponent.class})
public interface DetailComponent {

    void inject(DetailActivity activity);

    DetailPresenter providesDetailPresenter();

    CommentAdapter providesCommentAdapter();

    LinearLayoutManager providesLayoutManager();

    DefaultItemAnimator providesItemAnimator();
}
