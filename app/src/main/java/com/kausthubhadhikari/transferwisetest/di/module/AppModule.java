package com.kausthubhadhikari.transferwisetest.di.module;

import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.kausthubhadhikari.transferwisetest.AppController;
import com.kausthubhadhikari.transferwisetest.model.api.NetworkInterface;
import com.kausthubhadhikari.transferwisetest.model.api.NetworkManager;
import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.model.database.dao.AppDatabase;
import com.kausthubhadhikari.transferwisetest.model.database.manager.PersistDataManager;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppConstants;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */
@Module
public class  AppModule {

    private AppController appController;

    public AppModule(AppController appController) {
        this.appController = appController;
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(AppConstants.TIMEOUT_TIME, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConstants.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NetworkInterface providesNetworkInterface(Retrofit retrofit) {
        return retrofit.create(NetworkInterface.class);
    }

    @Provides
    @Singleton
    public AppDatabase providesAppDatabase() {
        return Room.databaseBuilder(appController.getApplicationContext(), AppDatabase.class, AppConstants.DATABASE_NAME)
                .build();
    }


    @Singleton
    @Provides
    public PersistDataManager provdiesPersistDataManager(AppDatabase appDatabase,AppUtils appUtils) {
        return new PersistDataManager(appDatabase,appUtils);
    }

    @Singleton
    @Provides
    public NetworkManager providesNetworkManager(NetworkInterface networkInterface) {
        return new NetworkManager(networkInterface);
    }

    @Provides
    @Singleton
    public DataRepository provideDataRepository(NetworkManager networkManager, PersistDataManager dataManager) {
        return new DataRepository(networkManager, dataManager);
    }

    @Provides
    @Singleton
    public AppUtils provideAppUtils() {
        return new AppUtils();
    }

}
