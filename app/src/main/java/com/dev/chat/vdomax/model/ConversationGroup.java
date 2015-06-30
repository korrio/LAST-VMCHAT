package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class ConversationGroup {
    int id;
    String name;
    String imageUrl;
    String createdAt;
    public ConversationGroup(int id, String name, String imageUrl, String createdAt){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public ConversationGroup() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
