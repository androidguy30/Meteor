package com.kausthubhadhikari.transferwisetest.model.database.manager;

import com.google.gson.Gson;
import com.kausthubhadhikari.transferwisetest.model.database.dao.AppDatabase;
import com.kausthubhadhikari.transferwisetest.model.database.entity.PersistData;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.Images;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.User;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */

public class PersistDataManager {

    private AppDatabase appDatabase;
    private AppUtils appUtils;

    public PersistDataManager(AppDatabase appDatabase, AppUtils appUtils) {
        this.appDatabase = appDatabase;
        this.appUtils = appUtils;
    }

    /***
     * Adding Data to Persist.
     *
     * @param data
     */
    public int insertAll(ArrayList<HomePojo> data) {
        ArrayList<PersistData> tempData = new ArrayList<>();
        PersistData persistData = null;
        for (HomePojo homePojo : data) {
            persistData = new PersistData();
            persistData.setShotId(homePojo.id);
            persistData.setTitle(homePojo.title);
            persistData.setDescription(homePojo.description);
            persistData.setImages(new Gson().toJson(homePojo.images));
            persistData.setWidth(homePojo.width);
            persistData.setHeight(homePojo.height);
            persistData.setViews(homePojo.viewsCount);
            persistData.setLikes(homePojo.likesCount);
            persistData.setAnimated(homePojo.animated);
            persistData.setTags(new Gson().toJson(homePojo.tags));
            persistData.setCreated_at(homePojo.createdAt);
            persistData.setUpdated_at(homePojo.updatedAt);
            persistData.setUserData(new Gson().toJson(homePojo.user));
            persistData.setHtml_url(homePojo.htmlUrl);
            tempData.add(persistData);
        }
        appDatabase.persistDataDAO().clearData();
        appDatabase.persistDataDAO().insertAll(tempData);
        return tempData.size();
    }


    /**
     * Data filtering according to need.
     *
     * @return
     */
    public ArrayList<HomePojo> getData() {
        ArrayList<HomePojo> filteredData = new ArrayList<>();
        List<PersistData> retrievedData = appDatabase.persistDataDAO().getHomeData();
        HomePojo homePojo;
        for (PersistData persistData : retrievedData) {
            homePojo = new HomePojo();
            homePojo.id = persistData.getShotId();
            homePojo.title = persistData.getTitle();
            homePojo.description = persistData.getDescription();
            homePojo.images = new Gson().fromJson(persistData.getImages(), Images.class);
            homePojo.width = persistData.getWidth();
            homePojo.height = persistData.getHeight();
            homePojo.viewsCount = persistData.getViews();
            homePojo.likesCount = persistData.getLikes();
            homePojo.animated = persistData.isAnimated();
            homePojo.createdAt = persistData.getCreated_at();
            homePojo.updatedAt = persistData.getUpdated_at();
            homePojo.user = new Gson().fromJson(persistData.getUserData(), User.class);
            homePojo.htmlUrl = persistData.getHtml_url();
            homePojo.tags = new Gson().fromJson(persistData.getTags(), appUtils.tagsType());
            if (persistData.getComments() != null) {
                homePojo.comments = new Gson().fromJson(persistData.getComments(), appUtils.commentType());
            }
            filteredData.add(homePojo);
        }
        return filteredData;
    }

}
