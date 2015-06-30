package com.dev.chat.vdomax.event.retrofit.friend;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class GetFriendsEvent {
    private String userId;

    public GetFriendsEvent(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

}
