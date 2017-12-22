
package com.kausthubhadhikari.transferwisetest.model.pojo.misc;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable{

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
    public Links_ links;
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
    @SerializedName("members_count")
    @Expose
    public int membersCount;
    @SerializedName("projects_count")
    @Expose
    public int projectsCount;
    @SerializedName("rebounds_received_count")
    @Expose
    public int reboundsReceivedCount;
    @SerializedName("shots_count")
    @Expose
    public int shotsCount;
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
    @SerializedName("members_url")
    @Expose
    public String membersUrl;
    @SerializedName("shots_url")
    @Expose
    public String shotsUrl;
    @SerializedName("team_shots_url")
    @Expose
    public String teamShotsUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    protected Team(Parcel in) {
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
        membersCount = in.readInt();
        projectsCount = in.readInt();
        reboundsReceivedCount = in.readInt();
        shotsCount = in.readInt();
        canUploadShot = in.readByte() != 0;
        type = in.readString();
        bucketsUrl = in.readString();
        followersUrl = in.readString();
        followingUrl = in.readString();
        likesUrl = in.readString();
        membersUrl = in.readString();
        shotsUrl = in.readString();
        teamShotsUrl = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(htmlUrl);
        dest.writeString(avatarUrl);
        dest.writeString(bio);
        dest.writeString(location);
        dest.writeInt(bucketsCount);
        dest.writeInt(commentsReceivedCount);
        dest.writeInt(followersCount);
        dest.writeInt(followingsCount);
        dest.writeInt(likesCount);
        dest.writeInt(likesReceivedCount);
        dest.writeInt(membersCount);
        dest.writeInt(projectsCount);
        dest.writeInt(reboundsReceivedCount);
        dest.writeInt(shotsCount);
        dest.writeByte((byte) (canUploadShot ? 1 : 0));
        dest.writeString(type);
        dest.writeString(bucketsUrl);
        dest.writeString(followersUrl);
        dest.writeString(followingUrl);
        dest.writeString(likesUrl);
        dest.writeString(membersUrl);
        dest.writeString(shotsUrl);
        dest.writeString(teamShotsUrl);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
