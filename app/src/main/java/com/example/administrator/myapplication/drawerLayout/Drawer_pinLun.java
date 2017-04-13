package com.example.administrator.myapplication.drawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.example.administrator.myapplication.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Drawer_pinLun extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_pinlun);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    @OnClick(R.id.drawer_pinlun)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_pinlun:
                finish();
                break;

        }
    }
}
