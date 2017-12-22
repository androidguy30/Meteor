
package com.kausthubhadhikari.transferwisetest.model.pojo.misc;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Parcelable {

    @SerializedName("hidpi")
    @Expose
    public String hidpi;
    @SerializedName("normal")
    @Expose
    public String normal;
    @SerializedName("teaser")
    @Expose
    public String teaser;

    protected Images(Parcel in) {
        hidpi = in.readString();
        normal = in.readString();
        teaser = in.readString();
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hidpi);
        parcel.writeString(normal);
        parcel.writeString(teaser);
    }
}
