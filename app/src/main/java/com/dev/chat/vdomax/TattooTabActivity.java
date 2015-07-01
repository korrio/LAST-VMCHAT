package com.dev.chat.vdomax;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.dev.chat.vdomax.adapter.PagerAdapter;

/**
 * Created by root1 on 4/18/15.
 */
public class TattooTabActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setAllCaps(false);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setIndicatorColorResource(R.color.indigo_700);
        tabsStrip.setDividerColor(getResources().getColor(android.R.color.transparent));
        tabsStrip.setViewPager(viewPager);
    }

}