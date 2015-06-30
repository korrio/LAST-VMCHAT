package com.dev.chat.vdomax.fragment.aa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.GroupListAdapter;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.ConversationGroup;
import com.dev.chat.vdomax.utils.UserManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GroupListFragment extends BaseFragment {
    String url;

    UserManager manager;
    String userId;
    ArrayList<ConversationGroup> groupList = new ArrayList<ConversationGroup>();
    private GroupListAdapter groupListAdapter;
    private ListView groupListView;

    Boolean check = false;

    public GroupListFragment() {
    }

    public static Fragment newInstance() {
        GroupListFragment chatFragment = new GroupListFragment();
        return chatFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_list, container, false);
        AQuery aq = new AQuery(getActivity());

        groupListView = (ListView) rootView.findViewById(R.id.lvExp);
        groupListAdapter = new GroupListAdapter(getActivity(), groupList);

        groupListView.setAdapter(groupListAdapter);

        manager = new UserManager(getActivity());
        userId = manager.getPref().getString("password", "1");

        url = "http://chat.vdomax.com:1314/api/chat/group/" + userId;


        if(!check){
            aq.ajax(url, JSONObject.class, this, "getjson");
        }


        return rootView;
    }

    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);
        String name;
        String createdAt;
        String sub2;
        String groupAvatar = "";
        String avatarUrl = "";
        int conversationId;
        if (jo != null) {

            JSONArray obj = jo.optJSONArray("content");
            for (int a = 0; a < obj.length(); a++) {
                JSONObject object = obj.optJSONObject(a);
                conversationId = object.optInt("conversationId");
                
                name = object.optString("name");
                createdAt = object.optString("createdAt");

                sub2 = createdAt.substring(11, 16);

                groupAvatar = object.optString("avatar");
                avatarUrl = "http://chat.vdomax.com:1314" + groupAvatar;
                
                ConversationGroup item = new ConversationGroup(conversationId, name, avatarUrl, sub2);
                groupList.add(item);
            }


            groupListAdapter.notifyDataSetChanged();
            AQUtility.debug("done");



        }
    }
}
