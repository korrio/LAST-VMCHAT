package com.dev.chat.vdomax.adapter;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chat.vdomax.R;
import com.dev.chat.vdomax.VMChatApp;
import com.dev.chat.vdomax.model.Group;
import com.dev.chat.vdomax.model.User;

import com.dev.chat.vdomax.ui.CircleTransform;
import com.squareup.picasso.Picasso;


public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<Group> groups;


	public ExpandableListAdapter(Context context, ArrayList<Group> groups) {
		this.context = context;
		this.groups = groups;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		ArrayList<User> chList = groups.get(groupPosition).getItems();
		return chList.get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
							 boolean isLastChild, View convertView, ViewGroup parent) {

		User child = (User) getChild(groupPosition, childPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.layout_item_child, null);
		}



		TextView tv = (TextView) convertView.findViewById(R.id.textUser);
		ImageView imageView = (ImageView) convertView.findViewById(R.id.picProfile);

		Picasso.with(context)
				.load(VMChatApp.IMAGE_ENDPOINT + child.getAvatar())
						//.resize(sizePicProfile , sizePicProfile)
				.transform(new CircleTransform())
				.into(imageView);

		tv.setText(child.getName());


		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		ArrayList<User> chList = groups.get(groupPosition).getItems();
		return chList.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		Group group = (Group) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inf.inflate(R.layout.group_item, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.group_name);
		tv.setText(group.getName());
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}