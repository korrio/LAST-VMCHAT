package com.dev.chat.vdomax.event.retrofit.following;

import com.dev.chat.vdomax.model.followersmodel.FollowersModel;

/**
 * Created by Adisorn on 15/3/2558.
 */
public class GetFollowingsSuccessEvent {
    private FollowersModel followingsModel;
    public GetFollowingsSuccessEvent(FollowersModel followingsModel) {
        this.followingsModel = followingsModel;
    }

    public FollowersModel getFollowingsModel() {
        return followingsModel;
    }

    public void setFollowingsModel(FollowersModel followingsModel) {
        this.followingsModel = followingsModel;
    }
}
