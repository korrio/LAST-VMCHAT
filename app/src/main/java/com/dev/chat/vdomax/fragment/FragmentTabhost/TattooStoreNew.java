package com.dev.chat.vdomax.fragment.FragmentTabhost;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.AdapterTattooStroe;
import com.dev.chat.vdomax.model.TattooStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TattooStoreNew extends Fragment {
    String url3 = "http://ihdmovie.xyz/feed2.json";
    AdapterTattooStroe adapterTattooStroe;
    ArrayList<TattooStore> list = new ArrayList<TattooStore>();
    private ListView mListView;
    private static boolean isNotAdded = true;
    private int mPage;
    public static final String ARG_PAGE = "ARG_PAGE";


    public static TattooStoreNew newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TattooStoreNew fragment = new TattooStoreNew();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mPage = getArguments().getInt(ARG_PAGE);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tattoo_store, container, false);
        AQuery aq = new AQuery(getActivity());
        mListView = (ListView) rootView.findViewById(R.id.list_view);
        adapterTattooStroe = new AdapterTattooStroe(getActivity(),list);


            final View headerView = getActivity().getLayoutInflater().inflate(R.layout.item_header_tattoo_store_new,mListView, false);

            mListView.addHeaderView(headerView);


        mListView.setAdapter(adapterTattooStroe);

        aq.ajax(url3, JSONObject.class, this, "getjson");

        return rootView;
    }

    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);

        if (jo != null) {
            JSONArray ja = jo.optJSONArray("users");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.optJSONObject(i);

                JSONObject location = obj.optJSONObject("avatar");

                String url_avatra;

                if(location != null)
                    url_avatra = location.optString("url");
                else
                    url_avatra = "themes/vdomax1.1/images/default-female-avatar.png";


                String Avatra = "https://www.vdomax.com/"+url_avatra+"";
                Log.i("Test_chcl", Avatra);

                String name_title = obj.optString("name");
                String avatar_id = obj.optString("avatar_id");


//                TattooStore list_item = new Post(Avatra, name_title, null, null, null, null, null, null, null,null,null);
//
//                list.add(list_item);
            }
            adapterTattooStroe.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }
}