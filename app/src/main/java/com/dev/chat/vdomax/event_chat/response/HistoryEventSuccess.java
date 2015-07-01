package com.dev.chat.vdomax.event_chat.response;


import com.dev.chat.vdomax.model_chat.ChatMessage;

import java.util.List;

/**
 * Created by matthewlogan on 9/3/14.
 */
public class HistoryEventSuccess {

    public List<ChatMessage> content;
    public HistoryEventSuccess(List<ChatMessage> content) {
        this.content = content;
    }

}
