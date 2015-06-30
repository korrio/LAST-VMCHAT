package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class UpdateGroup {

    String name;
    String updatedBy;

    public UpdateGroup(String name, String updatedBy){
        this.name = name;
        this.updatedBy = updatedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
