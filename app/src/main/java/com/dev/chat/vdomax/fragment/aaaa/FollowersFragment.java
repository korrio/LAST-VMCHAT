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
import com.dev.chat.vdomax.adapter.contactlistfragment.tab.FollowersListAdapter;
import com.dev.chat.vdomax.event.retrofit.followers.GetFollowersSuccessEvent2;
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
public class FollowersFragment extends BaseFragment {

    @InjectView(R.id.listViewFollowers)
    ListView listViewFollowers;

    private FollowersListAdapter followersListAdapter;

    public FollowersFragment() {

    }

    public static FollowersFragment newInstance() {
        FollowersFragment followersFragment = new FollowersFragment();
        return followersFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_followers_tab, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Subscribe
    public void onEvent(GetFollowersSuccessEvent2 event) {
        Toast.makeText(getActivity(),"GetFollowersSuccessEvent2",Toast.LENGTH_LONG).show();
        initData(event.getFollowersModel());
    }


    void initData(final FollowersModel followersModel) {
        followersListAdapter = new FollowersListAdapter(getActivity(), followersModel);
        listViewFollowers.setAdapter(followersListAdapter);
        listViewFollowers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Dialog dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
                dialog.setContentView(R.layout.dialog_followers);
                CircularImageView proFileImage;
                ImageView coverImage;
                TextView titleName;
                TextView userName;
                TextView nameAt;

                proFileImage = (CircularImageView) dialog.findViewById(R.id.avatar);
                titleName = (TextView) dialog.findViewById(R.id.name_title);
                coverImage = (ImageView) dialog.findViewById(R.id.cover);
                userName = (TextView) dialog.findViewById(R.id.name_username);
                nameAt = (TextView) dialog.findViewById(R.id.name_at);

                String imageProfile = followersModel.getUsers().get(position).getAvatar();
                String nameProfile = followersModel.getUsers().get(position).getName();
                String coverProfile = followersModel.getUsers().get(position).getCover();
                String username = followersModel.getUsers().get(position).getUsername();
                String ImageProfileFillUrl = "https://www.vdomax.com/" + imageProfile + "";
                String ImageCoverFillUrl = "https://www.vdomax.com/" + coverProfile + "";

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
        followersListAdapter.addData(followersModel);
    }
}
