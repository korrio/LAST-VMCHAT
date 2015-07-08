package com.dev.chat.vdomax;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.adapter.TattooStoreDetailAdapter;
import com.dev.chat.vdomax.model.TattooStore;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class TattooDetailActivity extends ActionBarActivity {


    ArrayList<com.dev.chat.vdomax.model.TattooStore> list = new ArrayList<com.dev.chat.vdomax.model.TattooStore>();

    TattooStoreDetailAdapter adapterTattooStroe;
    ImageView sticker;
    TextView title_vdomax;
    TextView name_sticker;
    TextView date;
    TextView price;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tattoo_detail);

        sticker = (ImageView) findViewById(R.id.sticker);
        title_vdomax = (TextView) findViewById(R.id.title_vdomax);
        name_sticker = (TextView) findViewById(R.id.name_sticker);
        date = (TextView) findViewById(R.id.date);
        price = (TextView) findViewById(R.id.price);
        gridView = (GridView) findViewById(R.id.gridView);

        TattooStore tattoo = Parcels.unwrap(getIntent().getBundleExtra("bundle").getParcelable("tattoo"));

        title_vdomax.setText(tattoo.getCreate_by_name());
        name_sticker.setText(tattoo.getItem_set_name());

        Picasso.with(getApplicationContext())
                .load(tattoo.getImageLogo())
                .fit().centerCrop()
                .into(sticker);

        adapterTattooStroe = new TattooStoreDetailAdapter(getApplicationContext(),tattoo.getTitle_vdomax());
        gridView.setAdapter(adapterTattooStroe);
    }


}

