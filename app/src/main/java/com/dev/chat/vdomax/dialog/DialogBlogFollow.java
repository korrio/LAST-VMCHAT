package com.dev.chat.vdomax.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.chat.ChatFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adisorn on 7/3/2558.
 */
public class DialogBlogFollow extends Dialog {
    private Context context;
    private FragmentManager fragmentManager;
    public DialogBlogFollow(Context context , FragmentManager fragmentManager) {
        super(context);
        this.context = context;
        this.fragmentManager = fragmentManager;
        requestWindowFeature(Window.FEATURE_NO_TITLE);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_blog_follow);
            //sdfsdff
       ButterKnife.inject(this);
    }

    @OnClick(R.id.btBlock)
    public void onClickBtBlock(){

    }

    @OnClick(R.id.btFollow)
    public void onClickBtFollow(){

       // getContext().startActivity(new Intent(getContext() , ChatActivity.class));

        FragmentManager manager = fragmentManager;
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameFragment, new ChatFragment());
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
