package com.dev.chat.vdomax;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.dev.chat.vdomax.adapter.AdapterTattooStoreDeatil;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class TattooStoreActivity extends ActionBarActivity {


    ArrayList<com.dev.chat.vdomax.model.TattooStore> list = new ArrayList<com.dev.chat.vdomax.model.TattooStore>();

    AdapterTattooStoreDeatil adapterTattooStroe;
    ImageView sticker;
    TextView title_vdomax;
    TextView name_sticker;
    TextView date;
    TextView price;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_tattoo_store);
        AQuery aq = new AQuery(getApplicationContext());

        sticker = (ImageView) findViewById(R.id.sticker);
        title_vdomax = (TextView) findViewById(R.id.title_vdomax);
        name_sticker = (TextView) findViewById(R.id.name_sticker);
        date = (TextView) findViewById(R.id.date);
        price = (TextView) findViewById(R.id.price);
        gridView = (GridView) findViewById(R.id.gridView);

        com.dev.chat.vdomax.model.TattooStore tattoo = Parcels.unwrap(getIntent().getBundleExtra("bundle").getParcelable("example"));

        title_vdomax.setText(tattoo.getItem_set_name());
        name_sticker.setText(tattoo.getCreate_by_name());

        Picasso.with(getApplicationContext())
                .load(tattoo.getImageLogo())
                .fit().centerCrop()
                .into(sticker);

        adapterTattooStroe = new AdapterTattooStoreDeatil(getApplicationContext(),tattoo.getTitle_vdomax());
        gridView.setAdapter(adapterTattooStroe);
    }


}

