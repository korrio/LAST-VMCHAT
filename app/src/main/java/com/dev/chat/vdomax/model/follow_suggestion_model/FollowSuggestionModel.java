package com.dev.chat.vdomax.model.follow_suggestion_model;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class FollowSuggestionModel implements Parcelable{

    private static final String FIELD_STATUS = "status";
    private static final String FIELD_USERS = "users";
    private static final String FIELD_TOTAL = "total";


    @SerializedName(FIELD_STATUS)
    private int mStatus;
    @SerializedName(FIELD_USERS)
    private List<User> mUsers;
    @SerializedName(FIELD_TOTAL)
    private int mTotal;


    public FollowSuggestionModel(){

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

    public void setTotal(int total) {
        mTotal = total;
    }

    public int getTotal() {
        return mTotal;
    }

    public FollowSuggestionModel(Parcel in) {
        mStatus = in.readInt();
        mUsers = new ArrayList<User>();
        in.readTypedList(mUsers, User.CREATOR);
        mTotal = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FollowSuggestionModel> CREATOR = new Creator<FollowSuggestionModel>() {
        public FollowSuggestionModel createFromParcel(Parcel in) {
            return new FollowSuggestionModel(in);
        }

        public FollowSuggestionModel[] newArray(int size) {
        return new FollowSuggestionModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStatus);
        dest.writeTypedList(mUsers);
        dest.writeInt(mTotal);
    }

    @Override
    public String toString(){
        return "status = " + mStatus + ", users = " + mUsers + ", total = " + mTotal;
    }


}