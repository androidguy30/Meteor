package com.kausthubhadhikari.transferwisetest.model.api;

import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by kausthubhadhikari on 11/11/17.
 */

public interface NetworkInterface {

    @GET("shots")
    Observable<ArrayList<HomePojo>> getShots(@QueryMap Map<String, String> query);

    @GET("shots/{id}/comments")
    Observable<ArrayList<CommentsPojo>> getComments(@Path("id") String shotId, @Query("access_token") String accessToken);

}
