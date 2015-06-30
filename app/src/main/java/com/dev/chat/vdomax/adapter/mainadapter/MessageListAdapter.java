package com.dev.chat.vdomax.adapter.mainadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VMChatApp;
import com.dev.chat.vdomax.model.friendmodel.FriendsModel;
import com.dev.chat.vdomax.model.friendmodel.User;
import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by Adisorn on 1/3/2558.
 */
public class MessageListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    //   private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    // private HashMap<String, List<String>> _listDataChild;

    private int TYPE_GROUP = 0;
    private int TYPE_FRIEND = 1;


    private String lbGroup[] = {"","Friends"};
    private FriendsModel friendsModel;

    private int sizePicProfile;

//    public MessageListAdapter(Context _context, List<String> _listDataHeader, HashMap<String, List<String>> _listDataChild) {
//        this._context = _context;
//        this._listDataHeader = _listDataHeader;
//        this._listDataChild = _listDataChild;
//    }

    public MessageListAdapter(Context _context ,FriendsModel friendsModel) {
        this._context = _context;
        this.friendsModel = friendsModel;
        sizePicProfile = _context.getResources().getInteger(R.integer.sizePicProfile);
    }

    @Override
    public int getGroupCount() {
        //return _listDataHeader.size();
        return lbGroup.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // return _listDataChild.get(this._listDataHeader.get(groupPosition)).size();
        if (groupPosition == 0){
            return 0;
        }
        else {
            return friendsModel.getUsers().size();
        }

    }

    @Override
    public Object getGroup(int groupPosition) {
        //return _listDataHeader.get(groupPosition);
        return lbGroup[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (groupPosition == 0)
        {
            return "";
        }
        else
        {
            return friendsModel.getUsers().get(childPosition);
        }
        //return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_item_head, null);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.textSeparator);
        if (groupPosition == TYPE_GROUP){
            lblListHeader.setText(headerTitle);
        }
        else if (groupPosition == TYPE_FRIEND){
            lblListHeader.setText(headerTitle + " (" + friendsModel.getUsers().size() +")") ;
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        User user = (User)getChild(groupPosition , childPosition);
        //String childText = (String)getChild(groupPosition , childPosition);
        HolderChild holderChild;
        if (convertView != null){
            holderChild = (HolderChild)convertView.getTag();
        }
        else{
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_item_child, null);
            holderChild = new HolderChild(convertView);
            convertView.setTag(holderChild);

        }
//        if (convertView == null) {
//            holderChild = new HolderChild();
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.layout_item_child, null);
//            holderChild.textUser = (TextView)convertView.findViewById(R.id.textUser);
//            holderChild.picProfile = (ImageView)convertView.findViewById(R.id.picProfile);
//            convertView.setTag(holderChild);
//        }
//        else {
//            holderChild = (HolderChild)convertView.getTag();
//        }


        Picasso.with(_context)
                .load(VMChatApp.IMAGE_ENDPOINT + user.getAvatar())
                //.resize(sizePicProfile , sizePicProfile)
                .transform(new CircleTransform())
                .into(holderChild.picProfile);

        holderChild.textUser.setText(user.getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class HolderChild{
        @InjectView(R.id.textUser)
        TextView textUser;
        @Optional @InjectView(R.id.picProfile)
        ImageView picProfile;

        HolderChild(View view) {
            ButterKnife.inject(this , view);
        }
    }

}
