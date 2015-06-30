package com.dev.chat.vdomax.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable {

    private long id;
    private String name;
    private String descr;

    private List<User> itemList = new ArrayList<User>();

    public Category(long id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<User> getItemList() {
        return itemList;
    }

    public void setItemList(List<User> itemList) {
        this.itemList = itemList;
    }



}
