package com.dev.chat.vdomax.model;

/**
 * Created by root1 on 6/10/15.
 */
public class Conversation {

    int cid;
    String msg;
    String userName;
    String avatraUrl;
    String time;

    public Conversation(int cid,String msg, String userName, String avatraUrl, String time){
        this.cid = cid;
        this.msg = msg;
        this.userName = userName;
        this.avatraUrl = avatraUrl;
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatraUrl() {
        return avatraUrl;
    }

    public void setAvatraUrl(String avatraUrl) {
        this.avatraUrl = avatraUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
