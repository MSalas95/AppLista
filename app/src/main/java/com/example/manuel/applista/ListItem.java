package com.example.manuel.applista;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by manuel on 26/08/14.
 */
public class ListItem {
    int icon1,icon2;
    String tv1,tv2,tv3;

    public ListItem (int icon1, int icon2, String tv1, String tv2, String tv3) {
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
    }

    public int getIcon1() {
        return icon1;
    }

    public int getIcon2() {
        return icon2;
    }

    public String getTv1() {
        return tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public String getTv3() {
        return tv3;
    }
}
