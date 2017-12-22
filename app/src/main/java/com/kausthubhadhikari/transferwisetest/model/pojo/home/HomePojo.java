
package com.kausthubhadhikari.transferwisetest.model.pojo.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.Images;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.Team;
import com.kausthubhadhikari.transferwisetest.model.pojo.misc.User;

import java.util.List;

public class HomePojo implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("width")
    @Expose
    public int width;
    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("images")
    @Expose
    public Images images;
    @SerializedName("views_count")
    @Expose
    public String viewsCount;
    @SerializedName("likes_count")
    @Expose
    public String likesCount;
    @SerializedName("comments_count")
    @Expose
    public String commentsCount;
    @SerializedName("attachments_count")
    @Expose
    public int attachmentsCount;
    @SerializedName("rebounds_count")
    @Expose
    public int reboundsCount;
    @SerializedName("buckets_count")
    @Expose
    public int bucketsCount;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("attachments_url")
    @Expose
    public String attachmentsUrl;
    @SerializedName("buckets_url")
    @Expose
    public String bucketsUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
    @SerializedName("likes_url")
    @Expose
    public String likesUrl;
    @SerializedName("projects_url")
    @Expose
    public String projectsUrl;
    @SerializedName("rebounds_url")
    @Expose
    public String reboundsUrl;
    @SerializedName("animated")
    @Expose
    public boolean animated;
    @SerializedName("tags")
    @Expose
    public List<String> tags = null;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("team")
    @Expose
    public Team team;

    public CommentsPojo comments = null;

    public HomePojo(){

    }

    public HomePojo(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        width = in.readInt();
        height = in.readInt();
        viewsCount = in.readString();
        likesCount = in.readString();
        commentsCount = in.readString();
        attachmentsCount = in.readInt();
        reboundsCount = in.readInt();
        bucketsCount = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        htmlUrl = in.readString();
        attachmentsUrl = in.readString();
        bucketsUrl = in.readString();
        commentsUrl = in.readString();
        likesUrl = in.readString();
        projectsUrl = in.readString();
        reboundsUrl = in.readString();
        animated = in.readByte() != 0;
        tags = in.createStringArrayList();
    }

    public static final Creator<HomePojo> CREATOR = new Creator<HomePojo>() {
        @Override
        public HomePojo createFromParcel(Parcel in) {
            return new HomePojo(in);
        }

        @Override
        public HomePojo[] newArray(int size) {
            return new HomePojo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(width);
        parcel.writeInt(height);
        parcel.writeString(viewsCount);
        parcel.writeString(likesCount);
        parcel.writeString(commentsCount);
        parcel.writeInt(attachmentsCount);
        parcel.writeInt(reboundsCount);
        parcel.writeInt(bucketsCount);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(htmlUrl);
        parcel.writeString(attachmentsUrl);
        parcel.writeString(bucketsUrl);
        parcel.writeString(commentsUrl);
        parcel.writeString(likesUrl);
        parcel.writeString(projectsUrl);
        parcel.writeString(reboundsUrl);
        parcel.writeByte((byte) (animated ? 1 : 0));
        parcel.writeStringList(tags);
    }
}
