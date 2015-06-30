package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class FindFriends {
    String userName;
    String userId;
    String avatar;

    public FindFriends(String userName,String userId,String avatar){
        this.userName = userName;
        this.userId = userId;
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
