package com.dev.chat.vdomax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VMChatApp;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;
import com.dev.chat.vdomax.model.friendmodel.User;
import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;


public class FriendContactListAdapter extends BaseAdapter {
    private Context _context;
    private FriendsModel friendsModel;

    public FriendContactListAdapter(Context _context, FriendsModel friendsModel) {
        this._context = _context;
        this.friendsModel = friendsModel;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return friendsModel.getUsers().size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        User user = friendsModel.getUsers().get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_item_child, null);
            holder.textName = (TextView) convertView.findViewById(R.id.textUser);
            holder.picProfile = (ImageView) convertView.findViewById(R.id.picProfile);
            holder.textBio = (TextView)convertView.findViewById(R.id.bioUser);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        Picasso.with(_context)
                .load(VMChatApp.IMAGE_ENDPOINT + user.getAvatar())
                        //.resize(sizePicProfile , sizePicProfile)
                .transform(new CircleTransform())
                .into(holder.picProfile);

        holder.textName.setText(user.getName());
        if(!user.getAbout().equals(""))
            holder.textBio.setText(user.getAbout());
        else
            holder.textBio.setText("@"+user.getUsername());

        return convertView;
    }


    public static class ViewHolder {

        TextView textName;
        TextView textBio;
        ImageView picProfile;

    }
}

