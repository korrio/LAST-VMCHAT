package com.dev.chat.vdomax.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.mainadapter.MessageListAdapter;
import com.dev.chat.vdomax.dialog.DialogBlogFollow;
import com.dev.chat.vdomax.dialog.DialogLongClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 23/2/2558.
 */
public class MessageListFragment extends Fragment {



    @InjectView(R.id.epMessageList)
    ExpandableListView epMessageList;


    MessageListAdapter messageListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public MessageListFragment() {
    }

    public static Fragment newInstance() {

        MessageListFragment messageListFragment = new MessageListFragment();
        return messageListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_massagelist, container, false);

        ButterKnife.inject(this , rootView);
//        initUI(rootView);
//        initData();
        return rootView;
    }
    void initUI(View rootView){

        epMessageList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                new DialogBlogFollow(getActivity() , getActivity().getSupportFragmentManager()).show(); //show dialog

                return false;
            }
        });

        epMessageList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                int itemType =  epMessageList.getPackedPositionType(id);
                if (itemType != epMessageList.PACKED_POSITION_TYPE_GROUP){   // Check is not TYPE GROUP
                    new DialogLongClick(getActivity()).show();
                }


                return true;
            }
        });

    }
//    void initData(){
//
//        prepareListData();
//        messageListAdapter = new MessageListAdapter(getActivity() , listDataHeader , listDataChild);
//        epMessageList.setAdapter(messageListAdapter);
//        for (int countGroup = 0 ; countGroup< messageListAdapter.getGroupCount() ; countGroup++ ){
//            epMessageList.expandGroup(countGroup); // expandGroup
//        }
//
//    }
    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }


}
