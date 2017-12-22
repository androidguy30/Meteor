package com.kausthubhadhikari.transferwisetest.utils.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.di.injector.Injector;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((AppController) getApplicationContext()).getDaggerInjector());
        getPresenter().onViewCreated(savedInstanceState == null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().unsubscribe();
    }

    public abstract void inject(Injector injector);

    public abstract P getPresenter();
}
