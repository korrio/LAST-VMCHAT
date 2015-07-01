package com.dev.chat.vdomax.handler;

import android.content.Context;
import android.widget.Toast;

import com.dev.chat.vdomax.event_chat.GetConversationListEvent;
import com.dev.chat.vdomax.event_chat.GetConversationListEventSuccess;
import com.dev.chat.vdomax.event_chat.request.ConversationEvent;
import com.dev.chat.vdomax.event_chat.request.HistoryEvent;
import com.dev.chat.vdomax.event_chat.response.ConversationEventSuccess;
import com.dev.chat.vdomax.event_chat.response.HistoryDataResponse;
import com.dev.chat.vdomax.event_chat.response.HistoryEventSuccess;
import com.dev.chat.vdomax.model_chat.ConversationChat;
import com.dev.chat.vdomax.model_chat.ConversationOneToOne;
import com.squareup.otto.Subscribe;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class ChatApiHandler {


    private Context context;
    private ChatApiService api;
    private ApiBus apiBus;

    public ChatApiHandler(Context context, ChatApiService api, ApiBus apiBus) {
        this.context = context;
        this.api = api;
        this.apiBus = apiBus;
    }
    public void registerForEvents() {
        apiBus.register(this);
    }


    @Subscribe public void getConversationList(GetConversationListEvent event){

        api.getConversationList("", event.id, new Callback<ConversationChat>() {
            @Override
            public void success(ConversationChat conversationChat, Response response) {
                apiBus.post(new GetConversationListEventSuccess(conversationChat.getContent()));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe public void onGetHistory(HistoryEvent event) {
        Map<String,Integer> opt = new HashMap<>();
        opt.put("page",event.page);
        opt.put("size",event.size);

        api.getHistory(event.cid,opt, new Callback<HistoryDataResponse>() {
            @Override
            public void success(HistoryDataResponse historyDataResponse, Response response) {
                Toast.makeText(context,"success2",Toast.LENGTH_LONG).show();

                if(historyDataResponse.content.size() != 0)
                    apiBus.post(new HistoryEventSuccess(historyDataResponse.content));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Subscribe public void onGetConversation(ConversationEvent event) {

        Map<String, Integer> opt = new HashMap<>();
        opt.put("userId", event.userId);
        opt.put("partnerId", event.partnerId);

        String contentType = "application/json";


        api.getConversation(event.userId, event.partnerId, new Callback<ConversationOneToOne>() {
            @Override
            public void success(ConversationOneToOne conversationOneToOne, Response response) {
                Toast.makeText(context,"success1",Toast.LENGTH_LONG).show();
                apiBus.post(new ConversationEventSuccess(conversationOneToOne.id));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(context,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }








}
