package com.dev.chat.vdomax.fragment.FragmentTabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.GroupListAdapter;
import com.dev.chat.vdomax.adapter.ExpandableListAdapter;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingsSuccessEvent;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.Group;
import com.dev.chat.vdomax.model.ConversationGroup;
import com.dev.chat.vdomax.model.followingmodel.FollowingsModel;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class FollowingAndFollowingwerFragment extends BaseFragment {

    ArrayList<ConversationGroup> ch_list  = new ArrayList<ConversationGroup>();
    private GroupListAdapter ExpAdapter;
    private ExpandableListView ExpandList;
    FollowingsModel followingsModel;
    private ArrayList<Group> groups = new ArrayList<>();
    public FollowingAndFollowingwerFragment() {
    }

    public static Fragment newInstance() {
        FollowingAndFollowingwerFragment chatFragment = new FollowingAndFollowingwerFragment();
        return chatFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expandable_listview_fragment, container, false);


        ExpandList = (ExpandableListView) rootView.findViewById(R.id.expandableListView1);


        return rootView;
    }

    @Subscribe
    public void onGetFollowingSuccessEvent(GetFollowingsSuccessEvent getFollowingsSuccessEvent){
        Toast.makeText(getActivity(), "Following_Success", Toast.LENGTH_SHORT).show();
        Log.d("EVENTTTT ", "GetFollowingSuccess");
        // getFollowingSuccessEvent.get
        //groups.add(getFollowingSuccessEvent);
        initData(groups);
    }

    void initData(ArrayList<Group> groups){

        ExpandableListAdapter exAdpt = new ExpandableListAdapter(getActivity(),groups);
        ExpandList.setAdapter(exAdpt);
    }



}
