package com.dev.chat.vdomax.event_chat;

import com.dev.chat.vdomax.model_chat.ConversationChat;

import java.util.List;

/**
 * Created by Mac on 6/30/15.
 */
public class GetConversationListEventSuccess {
    public List<ConversationChat.ContentEntity> list;

    public GetConversationListEventSuccess(List<ConversationChat.ContentEntity> list) {
        this.list = list;
    }
}
