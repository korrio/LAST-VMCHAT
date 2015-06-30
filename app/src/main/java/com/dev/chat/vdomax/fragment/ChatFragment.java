package com.dev.chat.vdomax.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.chat.vdomax.R;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class ChatFragment extends Fragment{

    public ChatFragment() {
    }

    public static Fragment newInstance() {
        ChatFragment chatFragment = new ChatFragment();
        return chatFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat2, container, false);

        return rootView;
    }
}
