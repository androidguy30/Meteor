
package com.kausthubhadhikari.transferwisetest.model.pojo.misc;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable{

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("buckets_count")
    @Expose
    public int bucketsCount;
    @SerializedName("comments_received_count")
    @Expose
    public int commentsReceivedCount;
    @SerializedName("followers_count")
    @Expose
    public int followersCount;
    @SerializedName("followings_count")
    @Expose
    public int followingsCount;
    @SerializedName("likes_count")
    @Expose
    public int likesCount;
    @SerializedName("likes_received_count")
    @Expose
    public int likesReceivedCount;
    @SerializedName("projects_count")
    @Expose
    public int projectsCount;
    @SerializedName("rebounds_received_count")
    @Expose
    public int reboundsReceivedCount;
    @SerializedName("shots_count")
    @Expose
    public int shotsCount;
    @SerializedName("teams_count")
    @Expose
    public int teamsCount;
    @SerializedName("can_upload_shot")
    @Expose
    public boolean canUploadShot;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("pro")
    @Expose
    public Boolean pro;
    @SerializedName("buckets_url")
    @Expose
    public String bucketsUrl;
    @SerializedName("followers_url")
    @Expose
    public String followersUrl;
    @SerializedName("following_url")
    @Expose
    public String followingUrl;
    @SerializedName("likes_url")
    @Expose
    public String likesUrl;
    @SerializedName("shots_url")
    @Expose
    public String shotsUrl;
    @SerializedName("teams_url")
    @Expose
    public String teamsUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        htmlUrl = in.readString();
        avatarUrl = in.readString();
        bio = in.readString();
        location = in.readString();
        bucketsCount = in.readInt();
        commentsReceivedCount = in.readInt();
        followersCount = in.readInt();
        followingsCount = in.readInt();
        likesCount = in.readInt();
        likesReceivedCount = in.readInt();
        projectsCount = in.readInt();
        reboundsReceivedCount = in.readInt();
        shotsCount = in.readInt();
        teamsCount = in.readInt();
        canUploadShot = in.readByte() != 0;
        type = in.readString();
        bucketsUrl = in.readString();
        followersUrl = in.readString();
        followingUrl = in.readString();
        likesUrl = in.readString();
        shotsUrl = in.readString();
        teamsUrl = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(htmlUrl);
        parcel.writeString(avatarUrl);
        parcel.writeString(bio);
        parcel.writeString(location);
        parcel.writeInt(bucketsCount);
        parcel.writeInt(commentsReceivedCount);
        parcel.writeInt(followersCount);
        parcel.writeInt(followingsCount);
        parcel.writeInt(likesCount);
        parcel.writeInt(likesReceivedCount);
        parcel.writeInt(projectsCount);
        parcel.writeInt(reboundsReceivedCount);
        parcel.writeInt(shotsCount);
        parcel.writeInt(teamsCount);
        parcel.writeByte((byte) (canUploadShot ? 1 : 0));
        parcel.writeString(type);
        parcel.writeString(bucketsUrl);
        parcel.writeString(followersUrl);
        parcel.writeString(followingUrl);
        parcel.writeString(likesUrl);
        parcel.writeString(shotsUrl);
        parcel.writeString(teamsUrl);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
    }
}
