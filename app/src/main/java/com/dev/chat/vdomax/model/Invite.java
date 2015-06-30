package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class Invite {
    String inviteUserIds;
    String invitedBy;


    public  Invite(String inviteUserIds,String invitedBy){
        this.inviteUserIds = inviteUserIds;
        this.invitedBy = invitedBy;
    }

    public String getInviteUserIds() {
        return inviteUserIds;
    }

    public void setInviteUserIds(String inviteUserIds) {
        this.inviteUserIds = inviteUserIds;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }
}
