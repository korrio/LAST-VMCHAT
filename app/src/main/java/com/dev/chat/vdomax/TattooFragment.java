package com.dev.chat.vdomax;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.dev.chat.vdomax.adapter.TattooPagerAdapter;
import com.dev.chat.vdomax.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by root1 on 4/18/15.
 */
public class TattooFragment extends BaseFragment {

    public TattooFragment() {

    }

    public static Fragment newInstance() {
        TattooFragment fragment = new TattooFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contactlist, container, false);
        ButterKnife.inject(this, rootView);

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new TattooPagerAdapter(getChildFragmentManager()));

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        tabsStrip.setAllCaps(false);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setIndicatorColorResource(R.color.indigo_700);
        tabsStrip.setDividerColor(getResources().getColor(android.R.color.transparent));
        tabsStrip.setViewPager(viewPager);
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}