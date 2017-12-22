
package com.kausthubhadhikari.transferwisetest.model.pojo.misc;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ implements Parcelable {

    @SerializedName("web")
    @Expose
    public String web;
    @SerializedName("twitter")
    @Expose
    public String twitter;

    protected Links_(Parcel in) {
        web = in.readString();
        twitter = in.readString();
    }

    public static final Creator<Links_> CREATOR = new Creator<Links_>() {
        @Override
        public Links_ createFromParcel(Parcel in) {
            return new Links_(in);
        }

        @Override
        public Links_[] newArray(int size) {
            return new Links_[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(web);
        parcel.writeString(twitter);
    }
}
