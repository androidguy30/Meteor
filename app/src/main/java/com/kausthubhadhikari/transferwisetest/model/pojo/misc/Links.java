
package com.kausthubhadhikari.transferwisetest.model.pojo.misc;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable{

    @SerializedName("web")
    @Expose
    public String web;
    @SerializedName("twitter")
    @Expose
    public String twitter;

    protected Links(Parcel in) {
        web = in.readString();
        twitter = in.readString();
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
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
