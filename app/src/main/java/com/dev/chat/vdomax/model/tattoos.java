package com.dev.chat.vdomax.model;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class tattoos implements Parcelable{

    private static final String FIELD_TATTOO = "tattoo";
    private static final String FIELD_TOTAL = "total";


    @SerializedName(FIELD_TATTOO)
    private List<Tattoo> mTattoos;
    @SerializedName(FIELD_TOTAL)
    private int mTotal;


    public tattoos(){

    }

    public void setTattoos(List<Tattoo> tattoos) {
        mTattoos = tattoos;
    }

    public List<Tattoo> getTattoos() {
        return mTattoos;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

    public int getTotal() {
        return mTotal;
    }

    public tattoos(Parcel in) {
        mTattoos = new ArrayList<Tattoo>();
        in.readTypedList(mTattoos, Tattoo.CREATOR);
        mTotal = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<tattoos> CREATOR = new Creator<tattoos>() {
        public tattoos createFromParcel(Parcel in) {
            return new tattoos(in);
        }

        public tattoos[] newArray(int size) {
        return new tattoos[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mTattoos);
        dest.writeInt(mTotal);
    }

    @Override
    public String toString(){
        return "tattoos = " + mTattoos + ", total = " + mTotal;
    }


}