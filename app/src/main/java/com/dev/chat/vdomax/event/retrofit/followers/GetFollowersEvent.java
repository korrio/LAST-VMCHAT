package com.dev.chat.vdomax.event.retrofit.followers;

/**
 * Created by Adisorn on 15/3/2558.
 */
public class GetFollowersEvent {

    String UserId;

    public  GetFollowersEvent(String UserId){
        this.UserId = UserId;
    }

    public String getUserId() {
        return UserId;
    }
}
