package com.kausthubhadhikari.transferwisetest;

import android.app.Application;

import com.kausthubhadhikari.transferwisetest.di.injector.DaggerInjector;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */
public class AppController extends Application {

    private DaggerInjector daggerInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    public DaggerInjector getDaggerInjector() {
        if (daggerInjector == null) {
            daggerInjector = new DaggerInjector();
        }
        return daggerInjector;
    }

    public void initDagger() {
        getDaggerInjector().init(this);
    }

}
