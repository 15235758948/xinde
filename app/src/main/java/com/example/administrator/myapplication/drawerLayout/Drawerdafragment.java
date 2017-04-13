package com.example.administrator.myapplication.drawerLayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;


/**
 * Created by Administrator on 2017/4/5.
 */

public class Drawerdafragment extends Fragment{
    public static Drawerdafragment newInstance() {
        return new Drawerdafragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_dashang_list,null);

        return view;
    }
}
