package com.example.gsonpic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Samuel on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {
    ZooInfo[] zooInfo;
    Context context;

    public MyAdapter(Context context, ZooInfo[] zooInfo) {
        this.context = context;
        this.zooInfo = zooInfo;
    }

    @Override
    public int getCount() {
        return zooInfo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.myitem, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(zooInfo[position].E_Name);
        Picasso.with(context).load(zooInfo[position].E_Pic_URL).into(holder.imageView);
        return convertView;
    }

    private class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
