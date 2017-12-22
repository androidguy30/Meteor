package com.kausthubhadhikari.transferwisetest.detail.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.google.gson.Gson;
import com.kausthubhadhikari.transferwisetest.R;
import com.kausthubhadhikari.transferwisetest.detail.adapter.CommentAdapter;
import com.kausthubhadhikari.transferwisetest.detail.presenter.DetailPresenter;
import com.kausthubhadhikari.transferwisetest.detail.presenter.DetailView;
import com.kausthubhadhikari.transferwisetest.di.injector.Injector;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.home.HomePojo;
import com.kausthubhadhikari.transferwisetest.utils.base.BaseActivity;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppConstants;
import com.kausthubhadhikari.transferwisetest.utils.misc.AppUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends BaseActivity implements DetailView {

    @Inject
    DetailPresenter presenter;

    @Inject
    AppUtils appUtils;

    @Inject
    CommentAdapter adapter;

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    DefaultItemAnimator itemAnimator;

    @BindView(R.id.title)
    AppCompatTextView title;

    @BindView(R.id.noViews)
    AppCompatTextView noViews;

    @BindView(R.id.noLikes)
    AppCompatTextView noLikes;

    @BindView(R.id.location)
    AppCompatTextView location;

    @BindView(R.id.avatarImage)
    CircleImageView avatarImage;

    @BindView(R.id.shotImage)
    ImageView shotImage;

    @BindView(R.id.commentList)
    RecyclerView commentList;

    @BindView(R.id.authorName)
    AppCompatTextView shotAuthor;

    @BindView(R.id.description)
    AppCompatTextView description;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private HomePojo data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        data = new Gson().fromJson(getIntent().getExtras().getString(AppConstants.INTENT_HOME_POJO), HomePojo.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @Override
    public DetailPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onCommentLoaded(ArrayList<CommentsPojo> comments) {
        adapter.updateData(comments);
    }

    @Override
    public void onNetworkError(Throwable throwable) {

    }


    @Override
    public void setupViews() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        commentList.setLayoutManager(layoutManager);
        commentList.setItemAnimator(itemAnimator);

        title.setText(data.title);
        noLikes.setText(data.likesCount + " likes");
        noViews.setText(data.viewsCount + " views");
        shotAuthor.setText(data.user.name);
        description.setText(appUtils.getHTMLtoString(data.description));
        location.setText(data.user.location != null ? data.user.location : "Not Available");

        Glide.with(this)
                .load(data.images.hidpi)
                .transition(GenericTransitionOptions.with((dataSource, isFirstResource) -> new DrawableCrossFadeTransition(300, true)))
                .into(shotImage);

        Glide.with(this)
                .load(data.user.avatarUrl)
                .into(avatarImage);

        commentList.setAdapter(adapter);
        presenter.loadComments(data.id);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(AppConstants.BUNDLE_SHOT_DATA, data);
        outState.putParcelableArrayList(AppConstants.BUNDLE_COMMENTS_DATA, adapter.getData());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        data = savedInstanceState.getParcelable(AppConstants.BUNDLE_SHOT_DATA);
        adapter.updateData(savedInstanceState.getParcelableArrayList(AppConstants.BUNDLE_COMMENTS_DATA));
    }


    @OnClick({R.id.shareIcon,R.id.shareText})
    public void onClick(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Check this cool dribbble shot out!! "+data.htmlUrl);
        intent.setType("text/plain");
        startActivity(intent);
    }

}
