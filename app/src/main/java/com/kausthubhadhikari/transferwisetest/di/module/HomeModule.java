package com.kausthubhadhikari.transferwisetest.di.module;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import com.kausthubhadhikari.transferwisetest.di.scope.ActivityScope;
import com.kausthubhadhikari.transferwisetest.home.adapter.HomeAdapter;
import com.kausthubhadhikari.transferwisetest.home.presenter.HomePresenter;
import com.kausthubhadhikari.transferwisetest.home.views.activity.HomeActivity;
import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.utils.custom.CustomItemDecorator;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@Module
public class HomeModule {

    private HomeActivity activity;

    public HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public HomePresenter providesHomePresenter(DataRepository dataRepository) {
        return new HomePresenter(activity, dataRepository);
    }

    @Provides
    @ActivityScope
    public GridLayoutManager providesGridLayoutManager() {
        return new GridLayoutManager(activity.getApplicationContext(), 2);
    }

    @Provides
    @ActivityScope
    public DefaultItemAnimator providesItemAnimator() {
        return new DefaultItemAnimator();
    }

    @Provides
    @ActivityScope
    public HomeAdapter providesHomeAdapter() {
        return new HomeAdapter(activity);
    }

    @Provides
    @ActivityScope
    public CustomItemDecorator providesItemDecorator(AppUtils appUtils){
        return new CustomItemDecorator(appUtils.pxToDp(5));
    }

}
