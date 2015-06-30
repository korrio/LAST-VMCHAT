package com.dev.chat.vdomax.adapter.addfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VMChatApp;
import com.dev.chat.vdomax.model.follow_suggestion_model.Follow_SuggestionModel;
import com.dev.chat.vdomax.model.follow_suggestion_model.User;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Adisorn on 3/3/2558.
 */
public class ListAddFriendAdapter extends BaseAdapter{
    private Context context;
    private int sizePicProfile;

    private Follow_SuggestionModel followingModel;
    public ListAddFriendAdapter(Context context, Follow_SuggestionModel followingModel) {
        this.context = context;
        this.followingModel = followingModel;
        sizePicProfile = context.getResources().getInteger(R.integer.sizePicProfile);
    }

    @Override
    public int getCount() {
        return followingModel.getUsers().size();
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
            view = inflater.inflate(R.layout.layout_following_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
       User user = followingModel.getUsers().get(position);

        Picasso.with(context)
                .load(VMChatApp.IMAGE_ENDPOINT + user.getAvatar())
                .resize(sizePicProfile , sizePicProfile)
                .placeholder(R.drawable.avatar)
                .centerInside()
                .into(holder.picProfile);

        holder.lbUser.setText(user.getName());

        return view;
    }

    class ViewHolder {

        @InjectView(R.id.picProfile)
        ImageView picProfile;

        @InjectView(R.id.lbUser)
        TextView lbUser;

//        @InjectView(R.id.btInvite)
//        Button vtInvite;

        public ViewHolder(View view) {
            ButterKnife.inject(this , view);
        }
    }

}
