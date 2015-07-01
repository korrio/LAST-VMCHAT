package com.dev.chat.vdomax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.Conversation;
import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Conversation> list =new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<Conversation> list) {
        this.mContext= context;
        this.list=list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        Conversation item = list.get(position);
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.item_conversation, parent, false);

        TextView title = (TextView)view.findViewById(R.id.title);
        title.setText(item.getUserName());
        TextView duration = (TextView)view.findViewById(R.id.duration);
        duration.setText(item.getTime());
        TextView textView = (TextView)view.findViewById(R.id.artist);
        textView.setText(item.getMsg());

        ImageView imageView = (ImageView)view.findViewById(R.id.list_image);
        if(item.getAvatraUrl() != null ) {
            Picasso.with(mContext)
                    .load(item.getAvatraUrl())
                    .transform(new CircleTransform())
                    .into(imageView);
        }

        return view;
    }
}