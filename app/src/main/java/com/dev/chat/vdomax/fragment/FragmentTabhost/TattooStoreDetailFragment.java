package com.dev.chat.vdomax.fragment.FragmentTabhost;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.model.TattooStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TattooStoreDetailFragment extends Fragment {

    String url3 = "http://ihdmovie.xyz/feed2.json\"";
    ArrayList<TattooStore> list = new ArrayList<TattooStore>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_tattoo_store, container, false);
        AQuery aq = new AQuery(getActivity());

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

                Log.d("Check1234",obj.toString());

//                JSONObject location = obj.optJSONObject("avatar");
//
//                String url_avatra;
//
//                if(location != null)
//                    url_avatra = location.optString("url");
//                else
//                    url_avatra = "themes/vdomax1.1/images/default-female-avatar.png";
//
//
//                String Avatra = "https://www.vdomax.com/"+url_avatra+"";
//                Log.i("Test_chcl", Avatra);
//
//                String name_title = obj.optString("name");
//                String avatar_id = obj.optString("avatar_id");



                //list.add(list_item);
            }
            //adapterTattooStroe.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }

}