package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/6.
 */
public class RegisterActivity extends Activity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_register_activity);
        bind = ButterKnife.bind(this);
    }

    @OnClick({R.id.button,
              R.id.info_denglu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_denglu:
                finish();
                break;
            case R.id.button:
                Toast.makeText(this, "注册成功！", Toast.LENGTH_LONG).show();
                finish();
                break;
        }

    }
}
