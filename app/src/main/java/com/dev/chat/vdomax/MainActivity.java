package com.dev.chat.vdomax;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chat.vdomax.adapter.chat.MainChat;
import com.dev.chat.vdomax.chat.ChatFragment;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollowSuggestionEvent;
import com.dev.chat.vdomax.fragment.aaa.ContactViewPagerFragment;
import com.dev.chat.vdomax.fragment.aaa.ConversationViewPagerFragment;
import com.dev.chat.vdomax.fragment.addfriend.AddFriendFragment;
import com.dev.chat.vdomax.handler.ApiBus;
import com.dev.chat.vdomax.utils.UserManager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    enum TYPE_MENU{
        CONTACT_LIST , MESSAGE_LIST , CHAT
    }

    @InjectView(R.id.textNavigationBar)
    TextView textNavigationBar;

    @InjectView(R.id.navIconLeft)
    ImageView navIconLeft;

    @InjectView(R.id.navIconRight)
    ImageView navIconRight;
    private UserManager mManager;

    private FloatingActionButton fab1;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private FloatingActionMenu menu1;

    private Handler mUiHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(MainActivity.this);
        footerClickFragment(TYPE_MENU.CONTACT_LIST);

        mManager  = new UserManager(this);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        PushService.subscribe(getApplication(), "Free_version", MainActivity.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ParseInstallation.getCurrentInstallation().saveInBackground();
            }
        }).start();

        initFAB();


    }

    public void initFAB() {
        menu1 = (FloatingActionMenu) findViewById(R.id.menu1);

        final FloatingActionButton programFab1 = new FloatingActionButton(this);
        programFab1.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab1.setLabelText("Conference Chat");
        programFab1.setImageResource(R.drawable.group_placeholder);
        menu1.addMenuButton(programFab1);
        programFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FloatingMenusActivity.this, programFab1.getLabelText(), Toast.LENGTH_SHORT).show();
            }
        });

        menus.add(menu1);
        menu1.hideMenuButton(false);
        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

        menu1.setClosedOnTouchOutside(true);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setEnabled(false);
        fab1.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = "";

            switch (v.getId()) {
                case R.id.fab1:
                    text = fab1.getLabelText();
                    break;

            }

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(this , "Main onResume" , Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String notificationData = bundle.getString("com.parse.Data");
            if (notificationData != null) {
                Intent i =new Intent(getApplicationContext(), MainChat.class);
                startActivity(i);
            }

        }
        ApiBus.getInstance().register(MainActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
       // Toast.makeText(this , "Main onPause" , Toast.LENGTH_SHORT).show();
        ApiBus.getInstance().unregister(MainActivity.this);
    }

    @OnClick(R.id.navIconLeft)
    public void onClickNavIconLeft(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, AddFriendFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
        //Toast.makeText(MainActivity.this , "navIconLeft" , Toast.LENGTH_SHORT).show();

        textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));

        ApiBus.getInstance().post(new GetFollowSuggestionEvent());
    }
    @OnClick(R.id.navIconRight)
    public void onClickNavIconRight(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, ConversationViewPagerFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();

        textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Chat));

        //Toast.makeText(MainActivity.this , "navIconRight" , Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.layoutMessageListBt)
    public void onClickMenuMessageList(){

        footerClickFragment(TYPE_MENU.CONTACT_LIST);

    }

    @OnClick(R.id.layoutChatBt)
    public void onClickMenuChat(){

        footerClickFragment(TYPE_MENU.CHAT);

    }

    @OnClick(R.id.layoutContactBt)
    public void onClickMenuContact(){

        footerClickFragment(TYPE_MENU.MESSAGE_LIST);

    }
    private void footerClickFragment(TYPE_MENU type_menu){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type_menu == TYPE_MENU.CONTACT_LIST){
            transaction.replace(R.id.fragment, ContactViewPagerFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));
          //  navIconLeft.setVisibility(View.VISIBLE);
            //navIconRight.setVisibility(View.INVISIBLE);
        }
        else if (type_menu == TYPE_MENU.CHAT){
            transaction.replace(R.id.fragment, ChatFragment.newInstance());
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Chat));
           // navIconLeft.setVisibility(View.VISIBLE);
           // navIconRight.setVisibility(View.VISIBLE);
        }
        else if (type_menu == TYPE_MENU.MESSAGE_LIST){

            Intent i =new Intent(getApplicationContext(), TattooTabActivity.class);
            startActivity(i);


        }

        transaction.commit();
    }
}
