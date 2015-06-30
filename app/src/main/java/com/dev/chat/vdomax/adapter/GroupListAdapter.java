package com.dev.chat.vdomax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.ConversationGroup;
import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class GroupListAdapter extends BaseAdapter {
    private Context activity;
    public ArrayList<ConversationGroup> list = new ArrayList<ConversationGroup>();
    String[] strName;
    public GroupListAdapter(Context a, ArrayList<ConversationGroup> list) {
        activity = a;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ConversationGroup item = list.get(position);
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.list_item, null);
            holder.picProfile = (ImageView) convertView.findViewById(R.id.list_image);
            holder.tv = (TextView) convertView.findViewById(R.id.title);
            holder.id = (TextView) convertView.findViewById(R.id.artist);
            holder.duration = (TextView) convertView.findViewById(R.id.duration);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.tv.setText(item.getName());
        holder.id.setText(item.getId()+"");
        holder.duration.setText(item.getCreatedAt());

        Picasso.with(activity)
                .load(item.getImageUrl())
                .transform(new CircleTransform())
                .into(holder.picProfile);

        return convertView;
    }


    public static class ViewHolder {
        ImageView picProfile ;
        TextView tv ;
        TextView id;
        TextView duration;

    }
}

