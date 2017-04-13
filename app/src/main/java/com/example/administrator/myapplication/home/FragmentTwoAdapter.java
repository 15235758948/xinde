package com.example.administrator.myapplication.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public class FragmentTwoAdapter extends BaseAdapter{
    private List<Integer[]> list=new ArrayList<>();
    private Context context;
    public FragmentTwoAdapter(Activity activity, List<Integer[]> list) {
        this.context=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        FragmentTwoAdapter.ViewHolder holder =null;
        if (convertView==null){
            holder = new FragmentTwoAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_qtbj_list_item,null);
            holder.im = (ImageView) convertView.findViewById(R.id.list_image);

            convertView.setTag(holder);

        }else {
            holder= (FragmentTwoAdapter.ViewHolder) convertView.getTag();
        }
        holder.im.setImageResource(R.drawable.page3);
        return convertView;
    }
    class ViewHolder{
        ImageView im;
    }
}
