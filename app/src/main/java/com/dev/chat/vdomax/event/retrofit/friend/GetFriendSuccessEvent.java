package com.dev.chat.vdomax.event.retrofit.friend;

import com.dev.chat.vdomax.model.friendmodel.FriendsModel;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class GetFriendSuccessEvent {
    private FriendsModel frindModel;
    public GetFriendSuccessEvent(FriendsModel frindModel) {
        this.frindModel = frindModel;
    }

    public FriendsModel getFrindModel() {
        return frindModel;
    }

    public void setFrindModel(FriendsModel frindModel) {
        this.frindModel = frindModel;
    }
}
