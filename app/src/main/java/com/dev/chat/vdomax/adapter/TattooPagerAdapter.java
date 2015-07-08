package com.dev.chat.vdomax.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.chat.vdomax.fragment.FragmentTabhost.TattooStoreNew;
import com.dev.chat.vdomax.fragment.FragmentTabhost.TattooStoreTop;


/**
 * Created by root1 on 4/18/15.
 */
public class TattooPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Top", "New","Event"};

    public TattooPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return (position == 0)? new TattooStoreTop() : new TattooStoreNew();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }

}