package com.example.admin.housekeeper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2016/7/14.
 */
public class PhoneAdapter extends BaseAdapter {
    private ArrayList<PhoneNumber> mList;
    private Context mContext;

    public PhoneAdapter( Context context,ArrayList<PhoneNumber> list) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(mContext,R.layout.phone_number,null);
        }
        TextView tv_id = (TextView) convertView.findViewById(R.id.tv_phone_id);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_phone_name);
        TextView tv_number = (TextView) convertView.findViewById(R.id.tv_phone_number);
        tv_id.setText(mList.get(position).getId());
        tv_name.setText(mList.get(position).getName());
        tv_number.setText(mList.get(position).getNumber());
        return convertView;
    }
}
