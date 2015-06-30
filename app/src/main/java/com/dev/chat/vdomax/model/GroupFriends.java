package com.dev.chat.vdomax.model;

import com.google.gson.annotations.Expose;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by root1 on 6/9/15.
 */

@Parcel
public class GroupFriends {
    @Expose
    int id;
    @Expose
    String name;
    @Expose
    String urlImage;

    public  GroupFriends(){

    }

    public GroupFriends(int id,String name, String urlImag){
        this.id = id;
        this.name = name;
        this.urlImage = urlImag;
    }
}
