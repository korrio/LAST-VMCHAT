package com.dev.chat.vdomax.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.TattooStore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TattooStoreAdapter extends BaseAdapter {
    private Activity activity;
    public ArrayList<TattooStore> list = new ArrayList<TattooStore>();

    public TattooStoreAdapter(Activity a, ArrayList<TattooStore> list) {
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
        final ViewHolder holder;
        TattooStore item = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_tattoo_store, null);
            holder.txt_sticker_name = (TextView) convertView.findViewById(R.id.txt_sticker_name);
            holder.txt_day_sticker = (TextView) convertView.findViewById(R.id.txt_day_sticker);
            holder.sticker = (ImageView) convertView.findViewById(R.id.sticker);
            holder.cat_by = (TextView) convertView.findViewById(R.id.cat_by);
            holder.download = (ImageView) convertView.findViewById(R.id.download);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txt_sticker_name.setText(item.getItem_set_name());
        //holder.txt_day_sticker.setText(item.getName_sticker());
        holder.cat_by.setText(item.getCreate_by_name());

        Picasso.with(activity)
                .load(item.getImageLogo())
                .fit().centerCrop()
                .into(holder.sticker);
//        Picasso.with(activity)
//                .load(item.getImageProfileUrl())
//                .fit().centerCrop()
//                .into(holder.download);

        return convertView;
    }


    public static class ViewHolder {
        TextView txt_sticker_name;
        TextView txt_day_sticker;
        ImageView sticker;
        ImageView download;
        TextView cat_by;

    }
}

