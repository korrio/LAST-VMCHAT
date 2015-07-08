package com.dev.chat.vdomax.fragment.FragmentTabhost;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.TattooDetailActivity;
import com.dev.chat.vdomax.adapter.TattooStoreAdapter;
import com.dev.chat.vdomax.model.TattooStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;

public class TattooStoreTop extends Fragment {
    String url0 = "https://www.vdomax.com/market/api/market.php?action=getpopularitem&page=1&cat_id_list=3&mobile=1";
    String url1 = "https://www.vdomax.com/market/api/market.php?action=getmarketitem&cat_id_list=3&mobile=1";
    String url2 = "https://www.vdomax.com/market/api/market.php?action=getmarketitem&cat_id_list=3&search_term=vdomax&mobile=1";
    TattooStoreAdapter adapter;
    ArrayList<com.dev.chat.vdomax.model.TattooStore> list = new ArrayList<com.dev.chat.vdomax.model.TattooStore>();
    private ListView mListView;
    private static boolean isNotAdded = true;
    private int mPage;
    public static final String ARG_PAGE = "ARG_PAGE";


    public static TattooStoreTop newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TattooStoreTop fragment = new TattooStoreTop();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tattoo_store, container, false);
        AQuery aq = new AQuery(getActivity());
        mListView = (ListView) rootView.findViewById(R.id.list_view);
        adapter = new TattooStoreAdapter(getActivity(),list);

        final View headerView = getActivity().getLayoutInflater().inflate(R.layout.item_header_tattoo_store_top,mListView, false);
        mListView.addHeaderView(headerView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), TattooDetailActivity.class);
                Parcelable wrapped = Parcels.wrap(list.get(position-1));
                Bundle bundle = new Bundle();
                bundle.putParcelable("tattoo", wrapped);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });

        String url = "";
        switch (mPage) {
            case 0:
                url = url0;
                break;
            case 1:
                url = url1;
                break;
            case 2:
                url = url2;
                break;
        }


        aq.ajax(url, JSONObject.class, this, "getjson");

        return rootView;
    }

    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);

        if (jo != null) {
            JSONArray ja = jo.optJSONArray("tattoo");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.optJSONObject(i);
                JSONArray jArray = obj.optJSONArray("itemset");
                ArrayList<String> listdata = new ArrayList<String>();

                if (jArray != null) {
                    for (int j=0;j<jArray.length();j++){
                        listdata.add("https://www.vdomax.com/assets/items/tattoo/" + jArray.get(j).toString());
                    }
                }

                String imageFull = "https://www.vdomax.com/assets/items/tattoo/"+jArray.opt(0);

                String createByName = obj.optString("create_by_name");
                String itemSetName = obj.optString("item_set_name");

                String avatar = obj.optString("avatar_url");

                TattooStore list_item = new TattooStore(imageFull,listdata,null,null,null,createByName,itemSetName);

                list.add(list_item);
            }
            adapter.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }
}