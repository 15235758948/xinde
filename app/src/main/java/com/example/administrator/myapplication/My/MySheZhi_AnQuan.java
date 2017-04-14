package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/11.
 */
public class MySheZhi_AnQuan extends Activity {
    @BindView(R.id.text_anquan)
    TextView textAnquan;
    @BindView(R.id.anquan_shouji)
    TextView anquanShouji;
    @BindView(R.id.anquan_youxiang)
    TextView anquanYouxiang;
    @BindView(R.id.anquan_xiugaimima)
    TextView anquanXiugaimima;
    @BindView(R.id.anquan_zhifumima)
    TextView anquanZhifumima;
    private  Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_shezhi_anquan);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_anquan,
            R.id.anquan_shouji,
            R.id.anquan_youxiang,
            R.id.anquan_xiugaimima,
            R.id.anquan_zhifumima})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_anquan:
                finish();
                break;
            case R.id.anquan_shouji:
                intent = new Intent(this, AnQuan_ShouJi.class);
                startActivity(intent);

                break;
//            case R.id.anquan_youxiang:
//                break;
//            case R.id.anquan_xiugaimima:
//                break;
//            case R.id.anquan_zhifumima:
//                break;
        }
    }
}
