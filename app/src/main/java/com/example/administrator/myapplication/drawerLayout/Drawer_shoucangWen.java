package com.example.administrator.myapplication.drawerLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.FragmentTwoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/6.
 */

public class Drawer_shoucangWen extends Fragment {

    @BindView(R.id.list_wen)
    GridView listWen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_shoucang_wen, null);
        ButterKnife.bind(this, view);
        initList();
        return view;
    }
    private void initList() {

        List<Integer[]> list = new ArrayList<>();
        Integer[] imageIds = new Integer[]{
                R.drawable.page3,
        };
        for (int i = 0; i < 16; i++) {
            list.add(imageIds);
        }
        FragmentTwoAdapter fragmentTwoAdapter = new FragmentTwoAdapter(getActivity(), list);
        listWen.setAdapter(fragmentTwoAdapter);


    }

    public static Drawer_shoucangWen newInstance() {
        return new Drawer_shoucangWen();
    }
}
