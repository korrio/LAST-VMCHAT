package com.dev.chat.vdomax.fragment.aaa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.ConversationTabAdapter;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.utils.UserManager;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ConversationViewPagerFragment extends BaseFragment {
    UserManager manager;
    int userId;

    public ConversationViewPagerFragment() {
    }

    public static Fragment newInstance() {
        ConversationViewPagerFragment contactViewPagerFragment = new ConversationViewPagerFragment();
        return contactViewPagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = new UserManager(getActivity());
        userId = manager.getUserId();

        //ApiBus.getInstance().post(new GetFriendsEvent(userId));
        //ApiBus.getInstance().post(new GetFollowingsEvent(userId));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contactlist, container, false);

        ButterKnife.inject(this, rootView);
        initUI(rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //initDataTabHost();
        //callSocket();
    }

    void initUI(View view){

        //Tabs: CHATS + GROUPS
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ConversationTabAdapter(getChildFragmentManager()));

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsStrip.setAllCaps(false);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setIndicatorColorResource(R.color.indigo_700);
        tabsStrip.setDividerColor(getResources().getColor(android.R.color.transparent));
        tabsStrip.setViewPager(viewPager);

        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //ApiBus.getInstance().post(new GetFollowersEvent(userId + ""));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick(R.id.btCreateGroup) public void onClickCreateGroup(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.add(R.id.fragment, CreateGroupFragment.newInstance());
        //transaction.addToBackStack(null);
        //transaction.commit();
       // Toast.makeText(getActivity(), "navIconLeft", Toast.LENGTH_SHORT).show();

    }
    @OnClick(R.id.btCreateConference) public void onClickCreateConference(){

    }


}
