package com.example.administrator.myapplication.home;

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

import static com.example.administrator.myapplication.R.id.image_tm;

/**
 * Created by Administrator on 2017/3/23.
 */
public class FragmentAdapter extends BaseAdapter{
    private Context context;
    private List<String> list = new ArrayList<String>();
    public FragmentAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

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
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_wen_list_itm,null);
            holder.tv = (TextView) convertView.findViewById(R.id.info_title);
            holder.im= (ImageView) convertView.findViewById(R.id.image_tm);
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).toString());
       holder.im.setImageResource(R.drawable.liaotian1);


        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView im;
    }
}
