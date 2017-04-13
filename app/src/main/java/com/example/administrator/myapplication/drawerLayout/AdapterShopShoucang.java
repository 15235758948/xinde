package com.example.administrator.myapplication.drawerLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.myapplication.R.id.text_price2;

/**
 * Created by Administrator on 2017/4/6.
 */
public class AdapterShopShoucang extends BaseAdapter{
    private List<String> list=new ArrayList<>();
    private Context context;

    public AdapterShopShoucang(Activity activity, List<String> list) {
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
      ViewHolder holder =null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.drawer_shoucangshop_list,null);
           TextView price2= (TextView) convertView.findViewById(text_price2);
            price2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG );
            holder.tv= (TextView) convertView.findViewById(R.id.text_rx);

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
