package com.example.administrator.myapplication.more;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/25.
 */

public class MoreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_more,null);
        ButterKnife.bind(this,view);

        return view;
    }

    public static MoreFragment newInstance() {
        return new MoreFragment();
    }
}
