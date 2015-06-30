package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class CreateGroup {
    String name;
    String inviteUserIds;
    String createdBy;

    public CreateGroup(String name, String inviteUserIds, String createdBy){

        this.name = name;
        this.inviteUserIds = inviteUserIds;
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInviteUserIds() {
        return inviteUserIds;
    }

    public void setInviteUserIds(String inviteUserIds) {
        this.inviteUserIds = inviteUserIds;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
