package com.kausthubhadhikari.transferwisetest.home.presenter;

import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BasePresenter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */

public class HomePresenter extends BasePresenter {

    private HomeView view;
    private DataRepository repository;

    public HomePresenter(HomeView homeView, DataRepository repository) {
        super(homeView);
        this.view = homeView;
        this.repository = repository;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        view.setupViews();
        if (isLaunched) {
            loadShotList();
        }
    }

    public void loadShotList() {
        addDisponsable(repository.getShotList()
                .subscribeOn(Schedulers.io())
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onDataLoaded, this::onError));
    }

    public void onDataLoaded(ArrayList<HomePojo> data) {
        view.onDataReady(data);
    }

    public void onError(Throwable throwable) {
        view.onNetworkError(throwable);
    }
}
