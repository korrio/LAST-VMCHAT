package com.dev.chat.vdomax.model;

import com.dev.chat.vdomax.model.friendmodel.*;
import com.dev.chat.vdomax.model.friendmodel.User;

import java.util.ArrayList;
import java.util.List;

public class Post {

    String imageProfileUrl;
    String name;
    String date;
    String loveCount;
    String commentCount;
    String shareCount;
    String shortMessage;
    String message;
    String viewCount;
    String imagePostUrl;
    String mediaType;
    String id ;
    boolean selected = false;

    private Author author;
    private Media media;
    private ArrayList<Love> love = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Follow> follows = new ArrayList<>();
    private ArrayList<Youtube> youtubes = new ArrayList<>();





    public Post(String imageProfileUrl, String name, String date, String loveCount, String commentCount,
                String shareCount, String message, String shortMessage, String viewCount, String imagePostUrl,String mediaType, boolean selected,  String id) {

        this.imageProfileUrl = imageProfileUrl;
        this.name = name;
        this.date = date;
        this.loveCount = loveCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
        this.message = message;
        this.shortMessage = shortMessage;
        this.viewCount = viewCount;
        this.imagePostUrl = imagePostUrl;
        this.mediaType = mediaType;
        this.selected = selected;
        this.id = id;

    }

    public String getImageProfileUrl() {
        return imageProfileUrl;
    }

    public void setImageProfileUrl(String imageProfileUrl) {
        this.imageProfileUrl = imageProfileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getImagePostUrl() {
        return imagePostUrl;
    }

    public void setImagePostUrl(String imagePostUrl) {
        this.imagePostUrl = imagePostUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ArrayList<Love> getLove() {
        return love;
    }

    public void setLove(ArrayList<Love> love) {
        this.love = love;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String medieType) {
        this.mediaType = medieType;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
