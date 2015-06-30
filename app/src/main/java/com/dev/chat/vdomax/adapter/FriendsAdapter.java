package com.dev.chat.vdomax.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.Post;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FriendsAdapter extends BaseAdapter {
    private Activity activity;
    public ArrayList<Post> list = new ArrayList<Post>();

    public FriendsAdapter(Activity a, ArrayList<Post> list) {
        activity = a;
        this.list = list;
        this.list.addAll(list);
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
        ViewHolder holder;
        final Post item = list.get(position);
        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.create_group_layout, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.mem_info_txt_id);
            holder.avatar = (CircularImageView) convertView.findViewById(R.id.mem_photo_img_id);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            convertView.setTag(holder);

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Post _state = (Post) cb.getTag();
                    item.setSelected(cb.isChecked());

                }
            });
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.name.setText(item.getName());
        holder.checkBox.setChecked(item.isSelected());
        Picasso.with(activity)
                .load(item.getImageProfileUrl())
                .fit().centerCrop()
                .into(holder.avatar);
        return convertView;
    }


    public static class ViewHolder {
        TextView name;
        CircularImageView avatar;
        CheckBox checkBox;

    }


}

