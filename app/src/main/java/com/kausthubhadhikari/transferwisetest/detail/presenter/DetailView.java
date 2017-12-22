package com.kausthubhadhikari.transferwisetest.detail.presenter;

import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BaseView;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */

public interface DetailView extends BaseView {

    void onCommentLoaded(ArrayList<CommentsPojo> comments);

    void onNetworkError(Throwable throwable);

    void setupViews();

}
