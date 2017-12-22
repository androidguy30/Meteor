package com.kausthubhadhikari.transferwisetest.model.api;

import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public class NetworkManager {

    private NetworkInterface networkInterface;

    public NetworkManager(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }


    /**
     * Shot list.
     *
     * @return
     */
    public Observable<ArrayList<HomePojo>> getShotList() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(AppConstants.QUERY_SORT_KEY, AppConstants.QUERY_SORT_VALUE);
        queryParams.put(AppConstants.QUERY_AUTH_KEY, AppConstants.ACCESS_TOKEN);
        return networkInterface.getShots(queryParams);
    }


    /**
     * Shot Comments.
     *
     * @param shotId
     * @return
     */
    public Observable<ArrayList<CommentsPojo>> getComments(String shotId) {
        return networkInterface.getComments(shotId, AppConstants.ACCESS_TOKEN);
    }

}
