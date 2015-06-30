package com.dev.chat.vdomax.event.retrofit.following;

/**
 * Created by Adisorn on 15/3/2558.
 */
public class GetFollowingsEvent {
    private String userId;

    public GetFollowingsEvent(String userId){
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }
}
