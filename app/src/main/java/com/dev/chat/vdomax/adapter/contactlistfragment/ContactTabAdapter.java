package com.dev.chat.vdomax.adapter.contactlistfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.chat.vdomax.fragment.aaaa.FollowersFragment;
import com.dev.chat.vdomax.fragment.aaaa.FollowingFragment;
import com.dev.chat.vdomax.fragment.aaaa.FriendsFragment;

public class ContactTabAdapter extends FragmentPagerAdapter{

    private String tabTitles[] = new String[] { "Friends","Followings","Followers"};

    public ContactTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new FriendsFragment();
            //case 1 : return new ChatListFragment();
            //case 2 : return new GroupListFragment();
            case 1 : return new FollowingFragment();
            case 2 : return new FollowersFragment();

        }
        //add test
        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }
}
