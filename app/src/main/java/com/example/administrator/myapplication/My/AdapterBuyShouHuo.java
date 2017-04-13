package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public class AdapterBuyShouHuo extends BaseAdapter{
    private List<String> list = new ArrayList<>();
    private Context context;

    public AdapterBuyShouHuo(Activity activity, List<String> list) {
        this.context = activity;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.my_buy_shouhuoitem,null);
            holder.tv= (TextView) convertView.findViewById(R.id.text_jiage);
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
