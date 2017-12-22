package com.kausthubhadhikari.transferwisetest.di.module;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.kausthubhadhikari.transferwisetest.detail.adapter.CommentAdapter;
import com.kausthubhadhikari.transferwisetest.detail.presenter.DetailPresenter;
import com.kausthubhadhikari.transferwisetest.detail.view.DetailActivity;
import com.kausthubhadhikari.transferwisetest.di.scope.ActivityScope;
import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@Module
public class DetailModule {

    private DetailActivity activity;

    public DetailModule(DetailActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public DetailPresenter providesDetailPresenter(DataRepository repository) {
        return new DetailPresenter(activity, repository);
    }

    @ActivityScope
    @Provides
    public CommentAdapter providesCommentAdapter(AppUtils appUtils) {
        return new CommentAdapter(activity, appUtils);
    }

    @ActivityScope
    @Provides
    public LinearLayoutManager providesLayoutManager() {
        return new LinearLayoutManager(activity);
    }

    @ActivityScope
    @Provides
    public DefaultItemAnimator providesItemAnimator() {
        return new DefaultItemAnimator();
    }

}
