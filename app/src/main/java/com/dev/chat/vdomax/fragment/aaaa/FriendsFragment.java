package com.dev.chat.vdomax.fragment.aaaa;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.FriendContactListAdapter;
import com.dev.chat.vdomax.chat.ChatFragment;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;
import com.dev.chat.vdomax.utils.UserManager;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class FriendsFragment extends BaseFragment {

    @InjectView(R.id.epFriendList)
    ListView friendListView;

    private Bundle bundleState;

    private FriendContactListAdapter friendContactListAdapter;
    private FriendsModel friendsModel;

    int count = 1;

    public static FriendsFragment newInstance() {
        FriendsFragment friendsFragment = new FriendsFragment();
        return friendsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends_tab, container, false);

        ButterKnife.inject(this, rootView);

        if (bundleState != null) {
            initDataToView((FriendsModel) bundleState.getParcelable("friendModel"));
        } else {
            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
        }

        initEvent();
        return rootView;
    }


    @Override
    public void onDestroyView() {
        bundleState = new Bundle();
        bundleState.putParcelable("friendModel", friendsModel);

        super.onDestroyView();
    }


    @Subscribe
    public void onGetFriendSuccessEvent(GetFriendSuccessEvent event) {
        count++;
        this.friendsModel = event.getFrindModel();
        initDataToView(friendsModel);
    }


    void initDataToView(FriendsModel friendsModel) {
        friendContactListAdapter = new FriendContactListAdapter(getActivity(), friendsModel);
        friendListView.setAdapter(friendContactListAdapter);
    }

    void initEvent() {
        friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String imageProfile = friendsModel.getUsers().get(position).getAvatar();
                final String nameProfile = friendsModel.getUsers().get(position).getName();
                final String coverProfile = friendsModel.getUsers().get(position).getCover();
                final String username = friendsModel.getUsers().get(position).getUsername();
                final int userId = (int) friendsModel.getUsers().get(position).getId();

                String ImageProfileFillUrl = "https://www.vdomax.com/" + imageProfile + "";
                final String ImageCoverFillUrl = "https://www.vdomax.com/" + coverProfile + "";
                final Dialog dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
                dialog.setContentView(R.layout.dialog_followers);

                CircularImageView proFileImage;
                final ImageView coverImage;
                final TextView titleName;
                final TextView userName;
                final TextView nameAt;
                final TextView txtChat;

                proFileImage = (CircularImageView) dialog.findViewById(R.id.avatar);
                titleName = (TextView) dialog.findViewById(R.id.name_title);
                coverImage = (ImageView) dialog.findViewById(R.id.cover);
                userName = (TextView) dialog.findViewById(R.id.name_username);
                nameAt = (TextView) dialog.findViewById(R.id.name_at);
                txtChat = (TextView) dialog.findViewById(R.id.txtChat);

                nameAt.setText(nameProfile);
                userName.setText(username);
                titleName.setText(nameProfile);
                Picasso.with(getActivity())
                        .load(ImageProfileFillUrl)
                        .into(proFileImage);

                Picasso.with(getActivity())
                        .load(ImageCoverFillUrl)
                        .into(coverImage);

                txtChat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        UserManager user = new UserManager(getActivity());
                        Bundle data = new Bundle();
                        data.putInt("USER_ID_1", 6);
                        data.putInt("USER_ID_2", userId);
                        ChatFragment fragment = new ChatFragment();
                        fragment.setArguments(data);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameFragment, fragment, "CHAT_MAIN").addToBackStack(null).commit();

                        dialog.dismiss();
                    }
                });


                dialog.show();
            }
        });


    }


}
