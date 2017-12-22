package com.kausthubhadhikari.transferwisetest.di.injector;

import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.detail.view.DetailActivity;
import com.kausthubhadhikari.transferwisetest.di.component.AppComponent;
import com.kausthubhadhikari.transferwisetest.di.component.DaggerAppComponent;
import com.kausthubhadhikari.transferwisetest.di.component.DaggerDetailComponent;
import com.kausthubhadhikari.transferwisetest.di.component.DaggerHomeComponent;
import com.kausthubhadhikari.transferwisetest.di.module.AppModule;
import com.kausthubhadhikari.transferwisetest.di.module.DetailModule;
import com.kausthubhadhikari.transferwisetest.di.module.HomeModule;
import com.kausthubhadhikari.transferwisetest.home.views.activity.HomeActivity;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public class DaggerInjector implements Injector {

    private AppComponent appComponent;

    @Override
    public void init(AppController appController) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appController))
                .build();
    }

    @Override
    public void inject(HomeActivity activity) {
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(activity))
                .build()
                .inject(activity);
    }

    @Override
    public void inject(DetailActivity activity) {
        DaggerDetailComponent.builder()
                .appComponent(appComponent)
                .detailModule(new DetailModule(activity))
                .build()
                .inject(activity);
    }
}
