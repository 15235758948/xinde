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

public class Drawer_shoucangmovie extends Fragment {

    @BindView(R.id.list_shou)
    GridView listShou;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_shoucang_movie, null);
        ButterKnife.bind(this, view);
        initList();
        return view;
    }


    private void initList() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 28; i++) {
            list.add("更新至第" + i + "集");
        }
        AdapterMovieShoucang adapterMovieShoucang = new AdapterMovieShoucang(getActivity(), list);
        listShou.setAdapter(adapterMovieShoucang);


    }

    public static Drawer_shoucangmovie newInstance() {
        return new Drawer_shoucangmovie();
    }
}
