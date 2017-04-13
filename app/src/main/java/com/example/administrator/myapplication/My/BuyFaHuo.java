package com.example.administrator.myapplication.My;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/11.
 */

public class BuyFaHuo extends Fragment {
    @BindView(R.id.list_buyAll)
    ListView listBuyAll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_buy_all, null);
        ButterKnife.bind(this, view);
        initList();
        return view;
    }
    private void initList() {
        List<String> list = new ArrayList<String>();
        for (int i = 130; i < 150; i++) {
            list.add("¥"+i);
        }
        AdapterBuyFaHuo adapterBuyFaHuo = new AdapterBuyFaHuo(getActivity(), list);
        listBuyAll.setAdapter(adapterBuyFaHuo);


    }

    public static BuyFaHuo newInstance() {
        return new BuyFaHuo();
    }
}
