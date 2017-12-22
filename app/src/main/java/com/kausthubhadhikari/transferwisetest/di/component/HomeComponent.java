package com.kausthubhadhikari.transferwisetest.di.component;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import com.kausthubhadhikari.transferwisetest.di.module.HomeModule;
import com.kausthubhadhikari.transferwisetest.di.scope.ActivityScope;
import com.kausthubhadhikari.transferwisetest.home.adapter.HomeAdapter;
import com.kausthubhadhikari.transferwisetest.home.presenter.HomePresenter;
import com.kausthubhadhikari.transferwisetest.home.views.activity.HomeActivity;
import com.kausthubhadhikari.transferwisetest.utils.custom.CustomItemDecorator;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@ActivityScope
@Component(modules = {HomeModule.class}, dependencies = {AppComponent.class})
public interface HomeComponent {
    void inject(HomeActivity activity);

    HomePresenter providesHomePresenter();

    GridLayoutManager providesGridLayoutManager();

    DefaultItemAnimator providesItemAnimator();

    HomeAdapter providesHomeAdapter();

    CustomItemDecorator providesItemDecorator();
}
