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

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.contactlistfragment.tab.FollowersListAdapter;
import com.dev.chat.vdomax.event.retrofit.following.GetFollowingsSuccessEvent;
import com.dev.chat.vdomax.fragment.BaseFragment;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Adisorn on 24/2/2558.
 */
public class FollowingFragment extends BaseFragment {

    @InjectView(R.id.listViewFollowing)
    ListView followingListView;
    private FollowersListAdapter listFollowingAdapter;

    public FollowingFragment() {
    }

    public static FollowingFragment newInstance() {
        FollowingFragment followingFragment = new FollowingFragment();
        return followingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_following_tab, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Subscribe public void onGetFollowingSuccessEvent(GetFollowingsSuccessEvent event){
        initData(event.getFollowingsModel());
    }

    void initData(final FollowersModel followingsModel){
        listFollowingAdapter = new FollowersListAdapter(getActivity() ,followingsModel);
        followingListView.setAdapter(listFollowingAdapter);
        followingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
                dialog.setContentView(R.layout.dialog_following);
                CircularImageView proFileImage;
                ImageView coverImage;
                TextView titleName;
                TextView userName;
                TextView nameAt;

                String imageProfile = followingsModel.getUsers().get(position).getAvatar();
                String nameProfile = followingsModel.getUsers().get(position).getName();
                String coverProfile = followingsModel.getUsers().get(position).getCover();
                String username = followingsModel.getUsers().get(position).getUsername();

                String ImageProfileFillUrl = "https://www.vdomax.com/" + imageProfile + "";
                String ImageCoverFillUrl = "https://www.vdomax.com/" + coverProfile + "";

                proFileImage = (CircularImageView) dialog.findViewById(R.id.avatar);
                titleName = (TextView) dialog.findViewById(R.id.name_title);
                coverImage = (ImageView) dialog.findViewById(R.id.cover);
                //btnBlock = (Button) dialog.findViewById(R.id.btn_block);
                userName = (TextView) dialog.findViewById(R.id.name_username);
                nameAt = (TextView) dialog.findViewById(R.id.name_at);

                nameAt.setText(nameProfile);
                userName.setText(username);
                titleName.setText(nameProfile);
                Picasso.with(getActivity())
                        .load(ImageProfileFillUrl)
                        .into(proFileImage);

                Picasso.with(getActivity())
                        .load(ImageCoverFillUrl)
                        .into(coverImage);


                dialog.show();

            }
        });
    }



}
