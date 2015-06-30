package com.dev.chat.vdomax.model.friendmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class FriendsModel implements Parcelable{

    private static final String FIELD_STATUS = "status";
    private static final String FIELD_USERS = "users";
    private static final String FIELD_PER_PAGE = "per_page";
    private static final String FIELD_PAGE = "page";
    private static final String FIELD_TOTAL = "total";


    @SerializedName(FIELD_STATUS)
    private int mStatus;
    @SerializedName(FIELD_USERS)
    private List<User> mUsers;
    @SerializedName(FIELD_PER_PAGE)
    private int mPerPage;
    @SerializedName(FIELD_PAGE)
    private int mPage;
    @SerializedName(FIELD_TOTAL)
    private int mTotal;


    public FriendsModel(){

    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setUsers(List<User> users) {
        mUsers = users;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setPerPage(int perPage) {
        mPerPage = perPage;
    }

    public int getPerPage() {
        return mPerPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public int getPage() {
        return mPage;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

    public int getTotal() {
        return mTotal;
    }

    public FriendsModel(Parcel in) {
        mStatus = in.readInt();
        mUsers = new ArrayList<User>();
        in.readTypedList(mUsers, User.CREATOR);
        mPerPage = in.readInt();
        mPage = in.readInt();
        mTotal = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FriendsModel> CREATOR = new Creator<FriendsModel>() {
        public FriendsModel createFromParcel(Parcel in) {
            return new FriendsModel(in);
        }

        public FriendsModel[] newArray(int size) {
        return new FriendsModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStatus);
        dest.writeTypedList(mUsers);
        dest.writeInt(mPerPage);
        dest.writeInt(mPage);
        dest.writeInt(mTotal);
    }

    @Override
    public String toString(){
        return "status = " + mStatus + ", users = " + mUsers + ", perPage = " + mPerPage + ", page = " + mPage + ", total = " + mTotal;
    }


}