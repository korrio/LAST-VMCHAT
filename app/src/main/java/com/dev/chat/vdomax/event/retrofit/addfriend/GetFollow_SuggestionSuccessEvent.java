package com.dev.chat.vdomax.event.retrofit.addfriend;

import com.dev.chat.vdomax.model.follow_suggestion_model.FollowSuggestionModel;

/**
 * Created by Adisorn on 17/3/2558.
 */
public class GetFollow_SuggestionSuccessEvent {
    private FollowSuggestionModel follow_suggestionModel;

    public GetFollow_SuggestionSuccessEvent(FollowSuggestionModel follow_suggestionModel) {
        this.follow_suggestionModel = follow_suggestionModel;
    }

    public FollowSuggestionModel getFollow_suggestionModel() {
        return follow_suggestionModel;
    }

    public void setFollow_suggestionModel(FollowSuggestionModel follow_suggestionModel) {
        this.follow_suggestionModel = follow_suggestionModel;
    }
}
