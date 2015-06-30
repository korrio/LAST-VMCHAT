package com.dev.chat.vdomax.event.retrofit.addfriend;

import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;

/**
 * Created by Adisorn on 17/3/2558.
 */
public class GetFollow_SuggestionSuccessEvent {
    private Follow_SuggestionModel follow_suggestionModel;

    public GetFollow_SuggestionSuccessEvent(Follow_SuggestionModel follow_suggestionModel) {
        this.follow_suggestionModel = follow_suggestionModel;
    }

    public Follow_SuggestionModel getFollow_suggestionModel() {
        return follow_suggestionModel;
    }

    public void setFollow_suggestionModel(Follow_SuggestionModel follow_suggestionModel) {
        this.follow_suggestionModel = follow_suggestionModel;
    }
}
