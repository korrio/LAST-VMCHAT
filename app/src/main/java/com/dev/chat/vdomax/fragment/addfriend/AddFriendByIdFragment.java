package com.dev.chat.vdomax.fragment.addfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.chat.vdomax.R;

/**
 * Created by Adisorn on 17/3/2558.
 */
public class AddFriendByIdFragment extends Fragment {
    public static AddFriendByIdFragment newInstance() {
        return new AddFriendByIdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addfriend_by_id, container, false);

        return rootView;
    }
}
