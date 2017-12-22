package com.kausthubhadhikari.transferwisetest.detail.presenter;

import com.kausthubhadhikari.transferwisetest.model.database.DataRepository;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BasePresenter;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */

public class DetailPresenter extends BasePresenter {

    private DetailView view;
    private DataRepository repository;

    public DetailPresenter(DetailView view, DataRepository dataRepository) {
        super(view);
        this.view = view;
        this.repository = dataRepository;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        view.setupViews();
    }

    public void loadComments(String shotId) {
        repository.getCommentsFromAPI(shotId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onCommentsRetrieved, this::onError);
    }

    public void onCommentsRetrieved(ArrayList<CommentsPojo> comments) {
        view.onCommentLoaded(comments);
    }

    public void onError(Throwable throwable) {
        view.onNetworkError(throwable);
    }

}
