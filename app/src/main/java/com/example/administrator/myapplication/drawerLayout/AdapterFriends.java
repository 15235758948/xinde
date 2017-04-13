package com.example.administrator.myapplication.drawerLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.drawerLayout.Drawer_friends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */

public class AdapterFriends extends BaseAdapter {
//    private final Context context;
//    private final List<String> list;
//    private final Map<View, Map<Integer, View>> cache = new HashMap<View, Map<Integer, View>>();
//
//    public AdapterFriends(Context context, List<String> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return getItem(position).hashCode();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = convertView;
//        TextView tv;
//        ImageView iv;
//        if (v == null) {
//            LayoutInflater inflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = inflater.inflate(R.layout.drawer_friends_list, parent, false);
//        }
//        Map<Integer, View> itemMap = cache.get(v);
//        if (itemMap == null) {
//            itemMap = new HashMap<Integer, View>();
//            tv = (TextView) v.findViewById(R.id.textView17);
//            iv = (ImageView) v.findViewById(R.id.imageView15);
//            itemMap.put(R.id.textView17, tv);
//            itemMap.put(R.id.imageView15, iv);
//            cache.put(v, itemMap);
//        } else {
//            tv = (TextView) itemMap.get(R.id.textView17);
//            iv = (ImageView) itemMap.get(R.id.imageView15);
//        }
//        final String item = (String) getItem(position);
//        tv.setText(item);
//        iv.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,
//                        String.format("Image clicked: %s", item),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//        return v;
//    }
    private List<String> list=new ArrayList<>();
    private Context context;

    public AdapterFriends(Drawer_friends drawer_friends, List<String> list) {
        this.context=drawer_friends;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.drawer_friends_list,null);
            holder.tv = (TextView) convertView.findViewById(R.id.textView17);

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
