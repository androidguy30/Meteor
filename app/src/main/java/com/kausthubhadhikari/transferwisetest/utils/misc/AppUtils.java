package com.kausthubhadhikari.transferwisetest.utils.misc;

import android.content.res.Resources;
import android.text.Html;

import com.google.gson.reflect.TypeToken;
import com.kausthubhadhikari.transferwisetest.model.pojo.comments.CommentsPojo;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 13/11/17.
 */

public class AppUtils {

    public Type commentType() {
        return new TypeToken<ArrayList<CommentsPojo>>() {
        }.getType();
    }

    public Type tagsType() {
        return new TypeToken<ArrayList<String>>() {
        }.getType();
    }

    public int pxToDp(int size) {
        return (int) (size * Resources.getSystem().getDisplayMetrics().density);
    }

    public String getHTMLtoString(String html) {
        if (html != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                return String.valueOf(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
            } else {
                return String.valueOf(Html.fromHtml(html));
            }
        } else {
            return "No Description";
        }

    }

}
