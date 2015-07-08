package com.dev.chat.vdomax.event.retrofit.friend;

import com.dev.chat.vdomax.model.friendmodel.FriendsModel;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class GetFriendSuccessEvent {
    private FriendsModel friendModel;
    public GetFriendSuccessEvent(FriendsModel friendModel) {
        this.friendModel = friendModel;
    }

    public FriendsModel getFriendModel() {
        return friendModel;
    }

    public void setFriendModel(FriendsModel friendModel) {
        this.friendModel = friendModel;
    }
}
