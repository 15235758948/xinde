package com.example.administrator.myapplication.drawerLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/6.
 */
public class Drawer_shoucangShop extends Fragment {
    @BindView(R.id.list_shop)
    GridView listShop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_shoucang_shop, null);
        ButterKnife.bind(this, view);
        initList();
        return view;
    }

    private void initList() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 28; i++) {
            list.add("画江湖之不良人解释道海股份的撒谎...");
        }
        AdapterShopShoucang adapterShopShoucang = new AdapterShopShoucang(getActivity(), list);
        listShop.setAdapter(adapterShopShoucang);


    }


    public static Drawer_shoucangShop newInstance() {
        return new Drawer_shoucangShop();
    }
}
