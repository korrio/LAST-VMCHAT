package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/6/15.
 */
public class Block {
    String name;
    String message;
    String type;
    String path;
    String value;

    public Block( String name,String message,String type,String path, String value){
        this.name = name;
        this.message = message;
        this.type = type;
        this.path = path;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
