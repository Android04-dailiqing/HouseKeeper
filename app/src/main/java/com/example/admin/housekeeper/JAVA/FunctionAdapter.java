package com.example.admin.housekeeper.JAVA;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.housekeeper.Function;
import com.example.admin.housekeeper.R;

import java.util.ArrayList;

/**
 * Created by admin on 2016/7/18.
 */
public class FunctionAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Function> mList;

    public FunctionAdapter(Context context, ArrayList<Function> list) {
        mContext = context;
        mList = list;
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
        if (convertView == null){
            convertView = View.inflate(mContext,R.layout.gridview_main_item,null);
        }
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_main_grid);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_main_grid);
        iv_icon.setBackgroundResource(mList.get(position).getIcon());
        tv_name.setText(mList.get(position).getName());
        return convertView;
    }
}
