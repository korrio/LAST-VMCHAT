package com.dev.chat.vdomax.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.Post;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.Random;




public class AdapterFrText extends RecyclerView.Adapter<AdapterFrText.ViewHolder> {


    public ArrayList<Post> list = new ArrayList<Post>();
    public static Context context;

    OnItemClickListener mItemClickListener;


    public AdapterFrText(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.item_friend, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post item = list.get(position);


        holder.name.setText(item.getName());

        Picasso.with(context)
                .load(item.getImageProfileUrl())
                .fit().centerCrop()
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView name;
        CircularImageView avatar;
        Button btnFollow;


        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.profile_name);
            avatar = (CircularImageView) view.findViewById(R.id.profile_image);


            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }

    }


    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    /*
     * Snippet from http://stackoverflow.com/a/363692/1008278
     */
    public static int randInt(int min, int max) {
        final Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /* ==========This Part is not necessary========= */

}