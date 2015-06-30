package com.dev.chat.vdomax.fragment.addfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.addfriend.ListAddFriendAdapter;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollow_SuggestionSuccessEvent;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Adisorn on 17/3/2558.
 */
public class AddFriendFragment extends BaseFragment {

    @InjectView(R.id.listView)
    ListView listView;

    public AddFriendFragment() {
    }

    public static AddFriendFragment newInstance() {

        return new AddFriendFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addfriend, container, false);

        ButterKnife.inject(this , rootView);
        return rootView;
    }
    @Subscribe public void onGetFollow_SuggestionSuccess(GetFollow_SuggestionSuccessEvent event){
        initDataToView(event.getFollow_suggestionModel());
    }
    void initDataToView(Follow_SuggestionModel modelData){
        ListAddFriendAdapter adapter = new ListAddFriendAdapter(getActivity() , modelData);
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.QrCode)
    public void onClickQrCode(){

    }
    @OnClick(R.id.SearchById)
    public void onClickSearchById(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, AddFriendByIdFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
