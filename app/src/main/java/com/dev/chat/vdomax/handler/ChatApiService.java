package com.dev.chat.vdomax.handler;

import com.dev.chat.vdomax.event_chat.response.HistoryDataResponse;
import com.dev.chat.vdomax.model.Block;
import com.dev.chat.vdomax.model.CreateGroup;
import com.dev.chat.vdomax.model.FindFriends;
import com.dev.chat.vdomax.model.Invite;
import com.dev.chat.vdomax.model.ShotGroup;
import com.dev.chat.vdomax.model.Status;
import com.dev.chat.vdomax.model.UpdateGroup;
import com.dev.chat.vdomax.model.User;
import com.dev.chat.vdomax.model_chat.ConversationChat;
import com.dev.chat.vdomax.model_chat.ConversationOneToOne;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by Adisorn on 14/3/2558.
 */
public interface ChatApiService {

    @POST("/api/chat/block")
    public void getฺBlock(@Body String body, Callback<Block> responseJson);

    @POST("/api/chat/unblock")
    public void getUnฺBlock(@Body String body, Callback<Block> responseJson);

    @POST("/api/chat/notification/on")
    public void getOn(@Body String body, Callback<Status> responseJson);

    @POST("/api/chat/notification/off")
    public void getOff(@Body String body, Callback<Status> responseJson);

    @POST("/api/chat/group/create")
    public void getCreateGroup(@Body String body, Callback<CreateGroup> responseJson);



    @POST("/api/chat/group/{id}/invite")
    public void getInvite(@Body String body, @Path("id") int id, Callback<Invite> responseJson);

    @GET("/api/chat/find_friends")
    public void getFindFriends(@Field("searchTerm") String username, Callback<FindFriends> responseJson);

    @PUT("/api/chat/group/{id}/name")
    public void updateGroupName(@Body String body, @Path("id") int id,Callback<UpdateGroup> responseJson);

    @PUT("/api/chat/group/{id}/avatar")
    public void updateGroupAvatar(@Body String body, @Path("id") int id,Callback<UpdateGroup> responseJson);

    @GET("/api/chat/{id}")
    public void getChatById(@Body String body, @Path("id") int id,Callback<User> responseJson);

    @GET("/api/chat/{id}/history/android")
    public void getHistory( @Path("id") int id, @QueryMap Map<String, Integer> options,Callback<HistoryDataResponse> responseJson);

    @GET("/api/chat/list/{id}")
    public void getConversationList(@Body String body, @Path("id") int id, Callback<ConversationChat> responseJson);

    @FormUrlEncoded
    @POST("/chat/individual/create")
    public void getConversation
            (@Field("userId") int userId,
             @Field("partnerId") int partnerId
             //,@Header("Content-Type") String contentType
                    , Callback<ConversationOneToOne> responseJson);

    @GET("/api/chat/individual/{id}")
    public void getIndividualList(@Body String body, @Path("id") int id, Callback<ConversationChat> responseJson);

    @GET("/api/chat/group/{id}")
    public void getGroupList(@Body String body, @Path("id") int id,Callback<ShotGroup> callback);





}
