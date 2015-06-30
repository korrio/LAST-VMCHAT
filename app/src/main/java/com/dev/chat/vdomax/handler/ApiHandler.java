package com.dev.chat.vdomax.handler;

import android.content.Context;
import android.widget.Toast;

import com.dev.chat.vdomax.event.event_chat.GetConversationListEvent;
import com.dev.chat.vdomax.event.event_chat.GetConversationListEventSuccess;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollowSuggestionEvent;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollow_SuggestionSuccessEvent;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersEvent;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersSuccessEvent2;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingsEvent;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingsSuccessEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendsEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.followingmodel.FollowingsModel;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;
import com.dev.chat.vdomax.model_chat.ConversationChat;
import com.squareup.otto.Subscribe;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class ApiHandler {


    private Context context;
    private ApiService apiService;
    private ApiBus apiBus;

    private FriendsModel frindModel_data;
    private FollowingsModel followingsModel_data;
    private FollowersModel followersModel_data;


    public ApiHandler(Context context , ApiService apiService , ApiBus apiBus ) {
        this.context = context;
        this.apiService = apiService;
        this.apiBus = apiBus;
    }
    public void registerForEvents() {
        apiBus.register(this);
    }


    @Subscribe public void getFriendsList(GetFriendsEvent data){

        apiService.getFriends("",Integer.parseInt(data.getUserId()), new Callback<FriendsModel>() {
            @Override
            public void success(FriendsModel frindModel, Response response) {
                apiBus.post(new GetFriendSuccessEvent(frindModel));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context, "error " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Subscribe public void getFollowingsList(GetFollowingsEvent data){

        apiService.getFollowings("",Integer.parseInt(data.getUserId()), new Callback<FollowersModel>() {
            @Override
            public void success(FollowersModel followingsModel, Response response) {
                apiBus.post(new GetFollowingsSuccessEvent(followingsModel));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe public void getFollowersList(GetFollowersEvent data){

        apiService.getFollowers("",Integer.parseInt(data.getUserId()),new Callback<FollowersModel>() {
            @Override
            public void success(FollowersModel followersModel, Response response) {
                apiBus.post(new GetFollowersSuccessEvent2(followersModel));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context , error.getMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Subscribe public void getFollowSuggestion(GetFollowSuggestionEvent event){

        apiService.getFollowSuggestion("",new Callback<Follow_SuggestionModel>() {
            @Override
            public void success(Follow_SuggestionModel follow_suggestionModel, Response response) {
                apiBus.post(new GetFollow_SuggestionSuccessEvent(follow_suggestionModel));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe public void getConversationList(GetConversationListEvent event){

        apiService.getConversationList("", event.id, new Callback<ConversationChat>() {
            @Override
            public void success(ConversationChat conversationChat, Response response) {
                apiBus.post(new GetConversationListEventSuccess(conversationChat.getContent()));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }






}
