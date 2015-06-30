package com.dev.chat.vdomax.event.retrofit.followers;

import com.dev.chat.vdomax.model.followersmodel.FollowersModel;

/**
 * Created by Adisorn on 15/3/2558.
 */
public class GetFollowersSuccessEvent2 {
    private FollowersModel followersModel;

    public GetFollowersSuccessEvent2(FollowersModel followersModel) {
        this.followersModel = followersModel;
    }

    public FollowersModel getFollowersModel() {
        return followersModel;
    }

    public void setFollowersModel(FollowersModel followersModel) {
        this.followersModel = followersModel;
    }
}
