package com.dev.chat.vdomax.adapter.contactlistfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.chat.vdomax.fragment.aa.ChatListFragment;
import com.dev.chat.vdomax.fragment.aa.GroupListFragment;

public class ConversationTabAdapter extends FragmentPagerAdapter{

    private String tabTitles[] = new String[] { "CHATS","GROUPS"};

    public ConversationTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new ChatListFragment();
            case 1 : return new GroupListFragment();

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
