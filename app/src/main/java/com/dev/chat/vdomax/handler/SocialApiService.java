package com.dev.chat.vdomax.handler;

import com.dev.chat.vdomax.model.UserMe;
import com.dev.chat.vdomax.model.follow_suggestion_model.FollowSuggestionModel;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface SocialApiService {

    @POST("/1.0/friends/{id}")
    public void getFriends(@Body String body,@Path("id") int id, Callback<FriendsModel> responseJson);

    @POST("/1.0/followings/{id}")
    public void getFollowings(@Body String body, @Path("id") int id, Callback<FollowersModel> responseJson);

    @POST("/1.0/followers/{id}")
    public void getFollowers(@Body String body, @Path("id") int id,Callback<FollowersModel> responseJson);

    @POST("/1.0/follow_suggestion")
    public void getFollowSuggestion(@Body String body, Callback<FollowSuggestionModel> responseJson);

    @GET("/user/{id}")
    public void getUser(@Body String body, @Path("id") int id,Callback<UserMe> responseJson);






}
