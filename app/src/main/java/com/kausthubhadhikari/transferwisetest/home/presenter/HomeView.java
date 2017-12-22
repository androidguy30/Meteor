package com.kausthubhadhikari.transferwisetest.home.presenter;

import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BaseView;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */

public interface HomeView extends BaseView {

    void setupViews();

    void onDataReady(ArrayList<HomePojo> data);

    void onError(Throwable throwable);

}
