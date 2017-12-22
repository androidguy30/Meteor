package com.kausthubhadhikari.transferwisetest.model.database;

import com.kausthubhadhikari.transferwisetest.model.api.NetworkManager;
import com.kausthubhadhikari.transferwisetest.model.database.manager.PersistDataManager;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */

public class DataRepository {

    private NetworkManager networkManager;
    private PersistDataManager dataManager;

    public DataRepository(NetworkManager networkManager, PersistDataManager dataManager) {
        this.networkManager = networkManager;
        this.dataManager = dataManager;
    }


    /**
     * Method to get Shotlist.
     *
     * @return
     */
    public Observable<ArrayList<HomePojo>> getShotList() {
        return Observable.concatArray(getShotsFromDB(),
                getShotsFromAPI()
                        .materialize()
                        .filter(arrayListNotification -> !arrayListNotification.isOnError())
                        .dematerialize());
    }


    /**
     * Get shots from database.
     *
     * @return
     */
    public Observable<ArrayList<HomePojo>> getShotsFromDB() {
        return Observable.fromCallable(() -> dataManager.getData());
    }


    /**
     * Get shots from API.
     *
     * @return
     */
    public Observable<ArrayList<HomePojo>> getShotsFromAPI() {
        return networkManager.getShotList().doOnNext(data -> storeShotsInDB(data));
    }


    /**
     * Store shots in Database.
     *
     * @param shotList
     */
    public void storeShotsInDB(ArrayList<HomePojo> shotList) {
        Observable.fromCallable(() -> dataManager.insertAll(shotList))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }


    /**
     * Get Comments from API.
     *
     * @param shotId
     * @return
     */
    public Observable<ArrayList<CommentsPojo>> getCommentsFromAPI(String shotId) {
        return networkManager.getComments(shotId);
    }


}
