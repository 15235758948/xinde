package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MyQuanZi extends Activity {

    @BindView(R.id.list_quanzi)
    ListView listQuanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_quanzi);
        ButterKnife.bind(this);
        initViewQ();
    }

    private void initViewQ() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 30; i++) {
            list.add( i +"");
        }
        AdapterQuanZi quanZiAdapter = new AdapterQuanZi(this, list);
        listQuanzi.setAdapter(quanZiAdapter);


    }

    @OnClick(R.id.info_quanzi)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.info_quanzi:
                finish();
                break;
        }
    }
}
