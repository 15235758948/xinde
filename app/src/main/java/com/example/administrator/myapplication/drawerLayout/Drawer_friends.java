package com.example.administrator.myapplication.drawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Drawer_friends extends Activity implements AdapterView.OnItemClickListener {


    @BindView(R.id.list_friends)
    ListView listFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_friends);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        initViewQ();
    }

    private void initViewQ() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 30; i++) {
            list.add("HAK12.");
        }
        AdapterFriends friendsAdapter = new AdapterFriends(this, list);
        listFriends.setAdapter(friendsAdapter);


    }

    @OnClick(R.id.drawer_friends)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_friends:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        TextView textView = (TextView) view.findViewById(R.id.textView17);
//        toast((String) textView.getText());
    }

//    private void toast(String text) {
//        Toast.makeText(this,
//                String.format("Item clicked: %s", text), Toast.LENGTH_SHORT)
//                .show();
//    }
}
