package com.dev.chat.vdomax.fragment.aa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.CustomAdapter;
import com.dev.chat.vdomax.event.event_chat.GetConversationListEventSuccess;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.Conversation;
import com.dev.chat.vdomax.model_chat.ConversationChat;
import com.dev.chat.vdomax.utils.UserManager;
import com.squareup.otto.Subscribe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class ChatListFragment extends BaseFragment {

    UserManager manager;
    String userId;
    ListView listView2;
    ArrayList<Conversation> list = new ArrayList<>();
    CustomAdapter customAdapter;
    String url;
    AQuery aq;

    Boolean check = false;
    public ChatListFragment() {
    }

    public static ChatListFragment newInstance() {
        ChatListFragment fragment = new ChatListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aq = new AQuery(getActivity());

        manager = new UserManager(getActivity());
        userId = manager.getPref().getString("password", "1");

        if(!check){
            //ApiBus.getInstance().post(new GetConversationListEvent(Integer.parseInt(userId)));
            url = "http://chat.vdomax.com:1314/api/chat/list/" + userId;
            aq.ajax(url, JSONObject.class, this, "getjson");
        }
    }

    @Subscribe public void onGetConversation(GetConversationListEventSuccess event) {
        for(int i = 0 ; i <= event.list.size() ; i++) {
            ConversationChat.ContentEntity conv = event.list.get(i);
            int conversationId = conv.getConversationId();
            String msg = conv.getLastMessage();
            String name = conv.getConversationMembers().get(0).getUsername();
            String avatar = conv.getConversationMembers().get(0).getAvatar();

            String avatarUrl;
            if (avatar != null) {
                avatarUrl = "https://www.vdomax.com/" + avatar + ".jpg";
            } else {
                avatarUrl = "https://www.vdomax.com/themes/vdomax1.1/images/default-female-avatarUrl.png";
            }

            String sub2 = conv.getLastHistoryDatetime().substring(11, 16);

            Conversation item = new Conversation(conversationId,msg, name, avatarUrl, sub2);
            list.add(item);
        }

        customAdapter.notifyDataSetChanged();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat_list, container, false);
        ButterKnife.inject(this, rootView);
        listView2 = (ListView) rootView.findViewById(R.id.listView2);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customAdapter = new CustomAdapter(getActivity(), list);
        listView2.setAdapter(customAdapter);

    }

    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {

        String name = "";
        String msg = "";
        String avatarUrl = "";
        String avatar = "";
        String time = "";
        String sub2 = "";
        int conversationId;
        if (jo != null) {
                JSONArray obj = jo.optJSONArray("content");
                for (int a = 0; a < obj.length(); a++) {
                    //
                        JSONObject object = obj.optJSONObject(a);

                        conversationId = object.optInt("conversationId");
                        msg = object.optString("lastMessage");
                        time = object.optString("lastHistoryDatetime");

                        sub2 = time.substring(11, 16);
                        JSONArray oop = object.optJSONArray("conversationMembers");
                        for (int j = 0; j < oop.length(); j++) {
                            JSONObject b = oop.optJSONObject(j);
                            name = b.optString("name");
                            avatar = b.optString("avatar");

                            if (avatar != null) {
                                avatarUrl = "https://www.vdomax.com/" + avatar + ".jpg";
                            } else {
                                avatarUrl = "https://www.vdomax.com/themes/vdomax1.1/images/default-female-avatarUrl.png";
                            }
                        }

                        Conversation item = new Conversation(conversationId,msg, name, avatarUrl, sub2);
                        list.add(item);
                    }
                }


            customAdapter.notifyDataSetChanged();
            AQUtility.debug("done");

    }
}