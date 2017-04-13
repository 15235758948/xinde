package com.example.administrator.myapplication.My;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.administrator.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */

public class AdapterSeeHistory extends BaseAdapter {
    private Context context;
    private List<String> list;
    public AdapterSeeHistory(MySeeHistory mySeeHistory, List<String> list) {
        this.context=mySeeHistory;
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
       ViewHolder holder =null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.my_seehistory_listitem,null);
            holder.tv = (TextView) convertView.findViewById(R.id.info_title);
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).toString());
        return convertView;
    }
    class ViewHolder{
        TextView tv;

    }
}
