package com.dev.chat.vdomax.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.adapter.FriendsAdapter;
import com.dev.chat.vdomax.event.retrofit.friend.GetFriendSuccessEvent;
import com.dev.chat.vdomax.fragment.FragmentTabhost.ListViewSwipeGesture;
import com.dev.chat.vdomax.model.Post;
import com.dev.chat.vdomax.utils.AndroidMultiPartEntity;
import com.squareup.otto.Subscribe;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class CreateGroupFragment extends BaseFragment {

    String url3 = "http://ihdmovie.xyz/feed2.json";
    FriendsAdapter adapter2;
    ArrayList<Post> list = new ArrayList<Post>();
    GridLayoutManager manager;
     ListView cmn_list_view;
    String url = "http://chat.vdomax.com:13002/api/chat/group/create";
    public long totalSize;
    ArrayList<Post> stateList = new ArrayList<>();

    ListViewSwipeGesture touchListener;
    ImageView avatra;
    public  EditText groupName;
    Button createGroup;
    public static CreateGroupFragment newInstance() {
        return new CreateGroupFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_creategroup, container, false);
        AQuery aq = new AQuery(getActivity());
        adapter2 = new FriendsAdapter(getActivity(),list);

        cmn_list_view	=	(ListView) rootView.findViewById(R.id.listView1);
        cmn_list_view.setAdapter(adapter2);
        //touchListener = new ListViewSwipeGesture(cmn_list_view, swipeListener, getActivity());
//        touchListener.SwipeType	=	ListViewSwipeGesture.Single;
      //  cmn_list_view.setOnTouchListener(touchListener);


        cmn_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post state = (Post) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), "Clicked on Row: " + state.getName(), Toast.LENGTH_LONG).show();

            }
        });
        avatra = (ImageView) rootView.findViewById(R.id.avatar);
        groupName = (EditText) rootView.findViewById(R.id.textView7);
        createGroup = (Button) rootView.findViewById(R.id.button);

        StringBuffer responseText = new StringBuffer();
        responseText.append("The  were selected...\n");
        stateList = adapter2.list;


        for (int i = 0; i < stateList.size(); i++) {
            Post state = stateList.get(i);

            if (state.isSelected()) {

                ja.put(state.getId());



            }
        }
        Toast.makeText(getActivity(), "Name:"+ja, Toast.LENGTH_LONG).show();
        Log.d("Checkon:", responseText+"");
        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                updateGroup();
            }
        });

        aq.ajax(url3, JSONObject.class, this, "getjson");

        return rootView;
    }

    JSONArray ja = new JSONArray();

    @Subscribe
    public void onGetFriendSuccessEvent(GetFriendSuccessEvent event) {
        // Toast.makeText(getActivity() , "FriendSuccess" , Toast.LENGTH_SHORT).show();
//        text.setText("OK : " + count);
//        count++;
//
//        this.friendModel = event.getFriendModel();
//
//        initDataToView(friendModel);
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


                String name_title = obj.optString("name");
                String id = obj.optString("id");
                Log.i("Test_chcl",id);
                Post list_item = new Post(Avatra, name_title, null, null, null, null, null, null, null,null,null,false,id);

                list.add(list_item);
            }
            adapter2.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }

    ProgressDialog dialog;
    public void updateGroup(){


        dialog = new ProgressDialog(getActivity());
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Updating profile");
        dialog.setMessage("กำลังสร้างกลุ่ม..");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(false);
        dialog.setMax(100);


        new UploadFileToServer().execute();

    }

    private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
        @Override
        protected void onPreExecute() {

            dialog.show();
            dialog.setProgress(0);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

            dialog.setProgress(progress[0]);


            dialog.setTitle(String.valueOf(progress[0]) + "%");

        }

        @Override
        protected String doInBackground(Void... params) {
            return uploadFile();
        }

        @SuppressWarnings("deprecation")
        private String uploadFile() {
            String responseString = null;

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);

            try {
                AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
                        new AndroidMultiPartEntity.ProgressListener() {

                            @Override
                            public void transferred(long num) {
                                publishProgress((int) ((num / (float) totalSize) * 100));
                                dialog.setProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });


                Charset chars = Charset.forName("UTF-8");

                int id = 6;

                entity.addPart("name",new StringBody(groupName.getText().toString(),chars));
                for (int i = 0 ; i< stateList.size() ; i++) {
                    entity.addPart("inviteUserIds", new StringBody(stateList.get(i).getId()));
                }
                entity.addPart("createdBy",new StringBody(String.valueOf(id),chars));

                totalSize = entity.getContentLength();
                httppost.setEntity(entity);

                // Making server call
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();

                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    // Server response
                    responseString = EntityUtils.toString(r_entity);
                } else {
                    responseString = "Error occurred! Http Status Code: " + statusCode;
                }

            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }

            return responseString;

        }

        @Override
        protected void onPostExecute(String result) {
            dialog.dismiss();
        Log.e("Check_Resu;t",result);
            super.onPostExecute(result);
        }

    }




}
