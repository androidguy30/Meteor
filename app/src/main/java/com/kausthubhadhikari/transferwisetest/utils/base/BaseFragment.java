package com.kausthubhadhikari.transferwisetest.utils.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.di.injector.Injector;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((AppController) getActivity().getApplicationContext()).getDaggerInjector());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().unsubscribe();
    }

    public abstract void inject(Injector injector);

    public abstract P getPresenter();
}
