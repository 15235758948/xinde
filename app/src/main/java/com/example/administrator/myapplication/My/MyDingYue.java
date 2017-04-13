package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.FragmentTwoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MyDingYue extends Activity {


    @BindView(R.id.list_dingyue)
    GridView listDingyue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dingyue);
        ButterKnife.bind(this);
        initViewQ();
    }

    private void initViewQ() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 27; i++) {
            list.add("更新至第" + i + "集");
        }
        AdapterDingYue dingYueAdapter = new AdapterDingYue(this, list);
        listDingyue.setAdapter(dingYueAdapter);

    }

    @OnClick(R.id.info_dingyue)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_dingyue:
                finish();
                break;
        }
    }
}
