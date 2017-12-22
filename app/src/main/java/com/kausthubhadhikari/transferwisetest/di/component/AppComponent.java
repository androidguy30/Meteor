package com.kausthubhadhikari.transferwisetest.di.component;

import com.google.gson.Gson;
import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.di.module.AppModule;
import com.kausthubhadhikari.transferwisetest.model.api.NetworkInterface;
import com.kausthubhadhikari.transferwisetest.model.api.NetworkManager;
import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.model.database.dao.AppDatabase;
import com.kausthubhadhikari.transferwisetest.model.database.manager.PersistDataManager;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void init(AppController appController);

    Gson providesGson();

    OkHttpClient providesOkHttpClient();

    Retrofit providesRetrofit();

    NetworkInterface providesNetworkInterface();

    AppDatabase providesAppDatabase();

    DataRepository provideDataRepository();

    PersistDataManager provdiesPersistDataManager();

    NetworkManager providesNetworkManager();

    AppUtils provideAppUtils();
}
