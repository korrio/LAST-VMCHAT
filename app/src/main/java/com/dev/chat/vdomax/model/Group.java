package com.dev.chat.vdomax.model;

import java.util.ArrayList;

public class Group {

    private String Name;
    private ArrayList<User> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<User> getItems() {
        return Items;
    }

    public void setItems(ArrayList<User> Items) {
        this.Items = Items;
    }

}