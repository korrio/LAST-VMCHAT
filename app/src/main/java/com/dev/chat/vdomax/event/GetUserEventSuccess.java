package com.dev.chat.vdomax.event;

import com.dev.chat.vdomax.model.UserMe;

/**
 * Created by Mac on 7/8/15.
 */
public class GetUserEventSuccess {
    public UserMe userMe;

    public GetUserEventSuccess(UserMe userMe) {
        this.userMe = userMe;
    }
}
