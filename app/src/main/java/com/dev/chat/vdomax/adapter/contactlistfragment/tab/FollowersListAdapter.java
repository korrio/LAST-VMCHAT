package com.dev.chat.vdomax.adapter.contactlistfragment.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VMChatApp;
import com.dev.chat.vdomax.model.followersmodel.FollowersModel;
import com.dev.chat.vdomax.model.followersmodel.User;
import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by Adisorn on 7/3/2558.
 */
public class FollowersListAdapter extends BaseAdapter {
    private Context context;
    private FollowersModel followersModel;
    private int sizePicProfile;

    public FollowersListAdapter(Context context, FollowersModel followersModel) {
        this.context = context;
        this.followersModel = followersModel;

        sizePicProfile = context.getResources().getInteger(R.integer.sizePicProfile);
    }
    public void addData(FollowersModel followersModel){
        if (this.followersModel == null){
            this.followersModel = followersModel;
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        if (this.followersModel == null){
            return 0;
        }
        else {
            return followersModel.getUsers().size();
        }

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        }
        else {
            LayoutInflater inflater = (LayoutInflater)   context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_follower_item, parent, false);
            holder = new ViewHolder(view);

            view.setTag(holder);
        }
        User user = followersModel.getUsers().get(position);

        Picasso.with(context)
                .load(VMChatApp.IMAGE_ENDPOINT + user.getAvatar())
                .resize(sizePicProfile , sizePicProfile)
                .transform(new CircleTransform())
                .into(holder.picProfile);

        holder.textName.setText(user.getName());
        if(!user.getAbout().equals(""))
            holder.textBio.setText(user.getAbout());
        else
            holder.textBio.setText("@"+user.getUsername());

        

        return view;
    }
    class ViewHolder {


        @Optional @InjectView(R.id.picProfile)
        ImageView picProfile;

        @Optional @InjectView(R.id.textUser)
        TextView textName;

        @Optional @InjectView(R.id.bioUser)
        TextView textBio;


        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
