package com.siddharthkumar.leagueapp;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Siddharth Kumar on 10/1/2017.
 */

public class Champion{

    String name;
    Image image;

    public Champion(String n, Image i){
        name=n;
        image = i;
    }


}
