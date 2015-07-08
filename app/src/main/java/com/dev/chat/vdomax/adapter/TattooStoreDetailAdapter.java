package com.dev.chat.vdomax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dev.chat.vdomax.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TattooStoreDetailAdapter extends BaseAdapter {
    private Context activity;
    public ArrayList<String> list = new ArrayList<String>();
    String[] strName;
    public TattooStoreDetailAdapter(Context a, ArrayList<String> list) {
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
        ViewHolder holder;
        String path = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_grid, null);
            holder.sticker = (ImageView) convertView.findViewById(R.id.imageView6);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        Picasso.with(activity)
                .load(path)
                .into(holder.sticker);

        return convertView;
    }


    public static class ViewHolder {
        ImageView sticker;

    }
}

