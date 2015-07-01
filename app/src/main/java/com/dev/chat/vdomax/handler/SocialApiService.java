package com.dev.chat.vdomax.handler;

import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Adisorn on 14/3/2558.
 */
public interface SocialApiService {


    @POST("/friends/{id}")
    public void getFriends(@Body String body,@Path("id") int id, Callback<FriendsModel> responseJson);

    @POST("/followings/{id}")
    public void getFollowings(@Body String body, @Path("id") int id, Callback<FollowersModel> responseJson);

    @POST("/followers/{id}")
    public void getFollowers(@Body String body, @Path("id") int id,Callback<FollowersModel> responseJson);

    @POST("/follow_suggestion")
    public void getFollowSuggestion(@Body String body, Callback<Follow_SuggestionModel> responseJson);






}
