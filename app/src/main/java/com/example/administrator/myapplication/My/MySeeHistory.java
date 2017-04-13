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
public class MySeeHistory extends Activity  {
    @BindView(R.id.info_seehistory)
    TextView infoSeehistory;
    @BindView(R.id.list_seehistory)
    ListView listSeehistory;
    private List<String> list;
    private AdapterSeeHistory seeHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        setContentView(R.layout.my_seehistory);
        ButterKnife.bind(this);
        initView();
//        getListView().setOnItemLongClickListener(this);
    }

    private void initView() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("破产姐妹第五季");
        }
        seeHistoryAdapter = new AdapterSeeHistory(this, list);
        listSeehistory.setAdapter(seeHistoryAdapter);
    }


    @OnClick(R.id.info_seehistory)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_seehistory:
                finish();
                break;
        }
    }


//    @Override
//    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//        String item = list.get(position);
//        SharedPreferences Addresses =getSharedPreferences(PRINT_SERVICE,0);
//        SharedPreferences.Editor editor = Addresses.edit();
//        editor.remove(item);
//        editor.commit();
//
//        Toast.makeText(getBaseContext(), item + "被删除了",
//                Toast.LENGTH_SHORT).show();
//
//        list.remove(item);
//        seeHistoryAdapter.notifyDataSetChanged();
//
//        return true;
//    }
}
