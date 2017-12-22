package com.kausthubhadhikari.transferwisetest.home.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.kausthubhadhikari.transferwisetest.R;
import com.kausthubhadhikari.transferwisetest.detail.view.DetailActivity;
import com.kausthubhadhikari.transferwisetest.di.injector.Injector;
import com.kausthubhadhikari.transferwisetest.home.adapter.HomeAdapter;
import com.kausthubhadhikari.transferwisetest.home.presenter.HomePresenter;
import com.kausthubhadhikari.transferwisetest.home.presenter.HomeView;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BaseActivity;
import com.kausthubhadhikari.transferwisetest.utils.custom.CustomItemDecorator;
import com.kausthubhadhikari.transferwisetest.utils.custom.CustomRecyclerView;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppConstants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView, HomeAdapter.OnClickListener {

    @BindView(R.id.shotList)
    CustomRecyclerView shotList;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    HomePresenter presenter;

    @Inject
    HomeAdapter adapter;

    @Inject
    DefaultItemAnimator itemAnimator;

    @Inject
    GridLayoutManager gridLayoutManager;

    @Inject
    CustomItemDecorator itemDecorator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onNetworkError(Throwable throwable) {
        Snackbar.make(shotList, throwable.toString(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setupViews() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        shotList.addItemDecoration(itemDecorator);
        shotList.setLayoutManager(gridLayoutManager);
        shotList.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onDataReady(ArrayList<HomePojo> data) {
        if (!data.isEmpty()) {
            adapter.updateData(data);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(shotList, throwable.toString(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void OnClick(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(AppConstants.INTENT_HOME_POJO, new Gson().toJson(adapter.getDataAtPosition(position)));
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(AppConstants.BUNDLE_HOME_DATA, adapter.getData());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.updateData(savedInstanceState.getParcelableArrayList(AppConstants.BUNDLE_HOME_DATA));
    }
}
