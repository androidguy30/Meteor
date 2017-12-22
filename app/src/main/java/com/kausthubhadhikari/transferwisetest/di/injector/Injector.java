package com.kausthubhadhikari.transferwisetest.di.injector;

import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.detail.view.DetailActivity;
import com.kausthubhadhikari.transferwisetest.home.views.activity.HomeActivity;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public interface Injector {

    void init(AppController appController);

    void inject(HomeActivity activity);

    void inject(DetailActivity activity);
}
