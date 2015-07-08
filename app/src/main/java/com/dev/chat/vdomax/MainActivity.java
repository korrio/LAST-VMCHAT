package com.dev.chat.vdomax;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chat.vdomax.chat.ChatFragment;
import com.dev.chat.vdomax.event.GetUserEvent;
import com.dev.chat.vdomax.event.GetUserEventSuccess;
import com.dev.chat.vdomax.event.retrofit.addfriend.GetFollowSuggestionEvent;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.fragment.TattooFragment;
import com.dev.chat.vdomax.fragment.aaa.ContactViewPagerFragment;
import com.dev.chat.vdomax.fragment.aaa.ConversationViewPagerFragment;
import com.dev.chat.vdomax.fragment.addfriend.AddFriendByIdFragment;
import com.dev.chat.vdomax.handler.ApiBus;
import com.dev.chat.vdomax.model.UserMe;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;
import com.dev.chat.vdomax.utils.UserManager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.GridHolder;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.ListHolder;
import com.orhanobut.dialogplus.OnCancelListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    enum TYPE_MENU{
        CONTACT_LIST , MESSAGE_LIST , TATTOO_LIST
    }

    @InjectView(R.id.textNavigationBar)
    TextView textNavigationBar;

    @InjectView(R.id.navIconLeft)
    ImageView navIconLeft;

    @InjectView(R.id.navIconRight)
    ImageView navIconRight;
    private UserManager mManager;

    private FloatingActionButton fab0;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private FloatingActionButton fab4;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private FloatingActionMenu menu1;

    private Handler mUiHandler = new Handler();

    boolean isGrid = false;
    boolean expanded = false;
    Holder holder;
    int gravity = 0;

    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;

        ButterKnife.inject(MainActivity.this);
        footerClickFragment(TYPE_MENU.CONTACT_LIST);

        mManager  = new UserManager(this);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        PushService.subscribe(getApplication(), "VMCHATUI", ChatRoomActivity.class);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ParseInstallation installation = ParseInstallation.getCurrentInstallation();
                installation.put("user_id", mManager.getUserId());
                installation.saveInBackground();
            }
        }).start();

        ApiBus.getInstance().post(new GetUserEvent(mManager.getUserId()));


    }

    FriendsModel friendsModel;

    @Subscribe
    public void onGetFriendSuccessEvent(GetFriendSuccessEvent event) {
        friendsModel = event.getFriendModel();
    }

    OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {

            dialog.dismiss();
            //Toast.makeText(MainActivity.this, position + " clicked", Toast.LENGTH_LONG).show();
        }
    };

    OnDismissListener dismissListener = new OnDismissListener() {
        @Override
        public void onDismiss(DialogPlus dialog) {
            //Toast.makeText(MainActivity.this, "dismiss listener invoked!", Toast.LENGTH_SHORT).show();
        }
    };

    OnCancelListener cancelListener = new OnCancelListener() {
        @Override
        public void onCancel(DialogPlus dialog) {
            //Toast.makeText(MainActivity.this, "cancel listener invoked!", Toast.LENGTH_SHORT).show();
        }
    };

    OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(DialogPlus dialog, View view) {
            switch (view.getId()) {
                case R.id.header_container:
                    //Toast.makeText(MainActivity.this, "Header clicked", Toast.LENGTH_LONG).show();
                    break;
                case R.id.footer_confirm_button:
                    //Toast.makeText(MainActivity.this, "Confirm button clicked", Toast.LENGTH_LONG).show();
                    break;
                case R.id.footer_close_button:
                    //Toast.makeText(MainActivity.this, "Close button clicked", Toast.LENGTH_LONG).show();
                    break;
            }
            dialog.dismiss();
        }
    };

    public void initGridFriendsDialog() {
        holder = new GridHolder(3);
        isGrid = true;
        //holder = new ListHolder();
        //isGrid = false;

        gravity = Gravity.CENTER;

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, isGrid,friendsModel);

        showCompleteDialog("Choose Friend","",holder, gravity, adapter, clickListener, itemClickListener, dismissListener, cancelListener,
                expanded);
    }

    public void initListAddFriendDialog() {
        //holder = new GridHolder(3);
        //isGrid = true;
        holder = new ListHolder();
        isGrid = false;

        gravity = Gravity.CENTER;

        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {

                switch (position) {
                    case 0:
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.add(R.id.frameFragment, AddFriendByIdFragment.newInstance());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case 1:
                        new IntentIntegrator(mActivity).initiateScan();
                        break;
                }

                dialog.dismiss();
                //Toast.makeText(MainActivity.this, position + " clicked", Toast.LENGTH_LONG).show();
            }
        };

        AddFriendAdapter adapter = new AddFriendAdapter(MainActivity.this, isGrid);

        showCompleteDialog("Add Friend","",holder, gravity, adapter, clickListener, itemClickListener, dismissListener, cancelListener,
                expanded);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            Log.d("MainActivity", "Weird");
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static Bitmap encodeToQrCode(String text, int width, int height){
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = null;
        try {
            matrix = writer.encode(text, BarcodeFormat.QR_CODE, 100, 100);
        } catch (WriterException ex) {
            ex.printStackTrace();
        }
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
            }
        }
        return bmp;
    }

    private void showCompleteDialog(String titleStr, String subTitleStr, Holder holder, int gravity, BaseAdapter adapter,
                                    OnClickListener clickListener, OnItemClickListener itemClickListener,
                                    OnDismissListener dismissListener, OnCancelListener cancelListener,
                                    boolean expanded) {
        final DialogPlus dialog = new DialogPlus.Builder(this)
                .setContentHolder(holder)
                .setHeader(R.layout.dialog_header)
                //.setFooter(R.layout.dialog_footer)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnClickListener(clickListener)
                .setOnItemClickListener(itemClickListener)
                .setOnDismissListener(dismissListener)
                .setExpanded(expanded)
                .setOnCancelListener(cancelListener)
                        //                .setOutMostMargin(0, 100, 0, 0)
                .create();

        View headerView = dialog.getHeaderView();
        TextView title = (TextView) headerView.findViewById(R.id.dialog_title);
        TextView subtitle = (TextView) headerView.findViewById(R.id.dialog_subtitle);

        title.setText(titleStr);
        subtitle.setText(subTitleStr);
        View footerView = dialog.getFooterView();
        dialog.show();

    }



    public void initFAB() {
//        menu1 = (FloatingActionMenu) findViewById(R.id.menu1);
//
//        /*
//        final FloatingActionButton programFab1 = new FloatingActionButton(this);
//        programFab1.setButtonSize(FloatingActionButton.SIZE_MINI);
//        programFab1.setLabelText("Conference Chat");
//        programFab1.setImageResource(R.drawable.conference);
//        programFab1.setColorNormal(R.color.fab_conference);
//        menu1.addMenuButton(programFab1);
//        programFab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(FloatingMenusActivity.this, programFab1.getLabelText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        */
//
//        menus.add(menu1);
//        menu1.hideMenuButton(false);
//        int delay = 400;
//        for (final FloatingActionMenu menu : menus) {
//            mUiHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    menu.showMenuButton(true);
//                }
//            }, delay);
//            delay += 150;
//        }
//
//        menu1.setClosedOnTouchOutside(true);
//        fab0 = (FloatingActionButton) findViewById(R.id.fab0);
//        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
//        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
//        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
//        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
//        //fab1.setEnabled(false);

    }


    @Subscribe public void onGetUserSuccess(GetUserEventSuccess event) {



        final UserMe.UserEntity user = event.userMe.getUser();

//        initFAB();
//
//        View.OnClickListener fabClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = "clicked";
//
//
//
//                switch (v.getId()) {
//                    case R.id.fab0:
//                        String imageProfile = user.getAvatar();
//                        String coverProfile = user.getCover();
//                        String nameProfile = user.getName();
//                        String username = user.getUsername();
//
//                        String ImageProfileFillUrl = "https://www.vdomax.com/" + imageProfile + "";
//                        final String ImageCoverFillUrl = "https://www.vdomax.com/" + coverProfile + "";
//                        final Dialog dialog = new Dialog(mActivity, R.style.FullHeightDialog);
//                        dialog.setContentView(R.layout.dialog_followers);
//
//                        CircularImageView proFileImage;
//                        final ImageView coverImage;
//                        final TextView titleName;
//                        final TextView userName;
//                        final TextView nameAt;
//                        final TextView txtChat;
//
//                        proFileImage = (CircularImageView) dialog.findViewById(R.id.avatar);
//                        titleName = (TextView) dialog.findViewById(R.id.name_title);
//                        coverImage = (ImageView) dialog.findViewById(R.id.cover);
//                        userName = (TextView) dialog.findViewById(R.id.name_username);
//                        nameAt = (TextView) dialog.findViewById(R.id.name_at);
//                        txtChat = (TextView) dialog.findViewById(R.id.txtChat);
//
//                        nameAt.setText(nameProfile);
//                        userName.setText(username);
//                        titleName.setText(nameProfile);
//                        Picasso.with(mActivity)
//                                .load(ImageProfileFillUrl)
//                                .into(proFileImage);
//
//                        Picasso.with(mActivity)
//                                .load(ImageCoverFillUrl)
//                                .into(coverImage);
//                        break;
//                    case R.id.fab1:
//                        UserManager user = new UserManager(getApplicationContext());
//                        Bundle data = new Bundle();
//                        data.putInt("USER_ID_1",user.getUserId());
//                        data.putInt("USER_ID_2", 3082);
//                        ChatFragment fragment = new ChatFragment();
//                        fragment.setArguments(data);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameFragment, fragment, "CHAT_MAIN").addToBackStack(null).commit();
//                        break;
//                    case R.id.fab2:
//
//                        break;
//                    case R.id.fab3:
//
//                        break;
//                    default:
//                        break;
//
//                }
//
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        fab0.setOnClickListener(fabClickListener);
//        fab1.setOnClickListener(fabClickListener);
//        fab2.setOnClickListener(fabClickListener);
//        fab3.setOnClickListener(fabClickListener);
//        fab4.setOnClickListener(fabClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(this , "Main onResume" , Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String notificationData = bundle.getString("com.parse.Data");
            if (notificationData != null) {
                UserManager user = new UserManager(this);
                Bundle data = new Bundle();
                data.putInt("USER_ID_1",user.getPref().getInt(UserManager.USER_ID, 1));
                data.putInt("USER_ID_2", 3082);
                ChatFragment fragment = new ChatFragment();
                fragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameFragment, fragment, "CHAT_MAIN").addToBackStack(null).commit();
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

        //initGridFriendsDialog();
        initListAddFriendDialog();

        /*

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, AddFriendFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
        //Toast.makeText(MainActivity.this , "navIconLeft" , Toast.LENGTH_SHORT).show();

        textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));
        */

        ApiBus.getInstance().post(new GetFollowSuggestionEvent());
    }
    @OnClick(R.id.navIconRight)
    public void onClickNavIconRight(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, ConversationViewPagerFragment.newInstance());
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
        footerClickFragment(TYPE_MENU.MESSAGE_LIST);
    }

    @OnClick(R.id.layoutContactBt)
    public void onClickMenuContact(){
        footerClickFragment(TYPE_MENU.TATTOO_LIST);
    }
    private void footerClickFragment(TYPE_MENU type_menu){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type_menu == TYPE_MENU.CONTACT_LIST){
            transaction.replace(R.id.fragment, ContactViewPagerFragment.newInstance());
            //transaction.addToBackStack(null);
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Contact));
        } else if (type_menu == TYPE_MENU.MESSAGE_LIST){
            transaction.replace(R.id.fragment, ConversationViewPagerFragment.newInstance());
            //transaction.addToBackStack(null);
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Chat));
        } else if(type_menu == TYPE_MENU.TATTOO_LIST) {
            transaction.replace(R.id.frameFragment, TattooFragment.newInstance());
            transaction.addToBackStack(null);
            textNavigationBar.setText(getResources().getString(R.string.txtNavigationBar_Tattoo));
        }

        transaction.commit();
    }
}
