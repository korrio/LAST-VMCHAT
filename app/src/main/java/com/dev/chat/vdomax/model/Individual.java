package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class Individual {

    String name;
    int inviteUserIds;
    int createdBy;
    int conversationId;
    String type;
    int[] userIds;
    String avatar;
    int createdAt;
    int ConversationMembers;


    public Individual(String name, int inviteUserIds, int createdBy, int conversationId, String type, int[] userIds,
                      String avatar,int createdAt, int ConversationMembers) {

        this.name=name;
        this.inviteUserIds = inviteUserIds;
        this.createdBy=createdBy;
        this.conversationId = conversationId;
        this.type=type;
        this.userIds = userIds;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.ConversationMembers = ConversationMembers;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInviteUserIds() {
        return inviteUserIds;
    }

    public void setInviteUserIds(int inviteUserIds) {
        this.inviteUserIds = inviteUserIds;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getUserIds() {
        return userIds;
    }

    public void setUserIds(int[] userIds) {
        this.userIds = userIds;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getConversationMembers() {
        return ConversationMembers;
    }

    public void setConversationMembers(int conversationMembers) {
        ConversationMembers = conversationMembers;
    }
}
