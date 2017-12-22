
package com.kausthubhadhikari.transferwisetest.model.pojo.comments;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.User;

public class CommentsPojo implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("likes_count")
    @Expose
    public String likesCount;
    @SerializedName("likes_url")
    @Expose
    public String likesUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("user")
    @Expose
    public User user;

    protected CommentsPojo(Parcel in) {
        id = in.readString();
        body = in.readString();
        likesCount = in.readString();
        likesUrl = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<CommentsPojo> CREATOR = new Creator<CommentsPojo>() {
        @Override
        public CommentsPojo createFromParcel(Parcel in) {
            return new CommentsPojo(in);
        }

        @Override
        public CommentsPojo[] newArray(int size) {
            return new CommentsPojo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(body);
        parcel.writeString(likesCount);
        parcel.writeString(likesUrl);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeParcelable(user, i);
    }
}
