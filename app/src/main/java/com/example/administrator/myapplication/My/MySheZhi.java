package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/10.
 */
public class MySheZhi extends Activity {
    @BindView(R.id.info_shezhi)
    TextView infoSheZhi;
    @BindView(R.id.shezhi_anquan)
    TextView shezhiAnquan;
    @BindView(R.id.shezhi_shezhi)
    TextView shezhiShezhi;
    @BindView(R.id.shezhi_bofang)
    TextView shezhiBofang;
    @BindView(R.id.shezhi_xiaozi)
    TextView shezhiXiaozi;
    @BindView(R.id.shezhi_jiancha)
    TextView shezhiJiancha;
    @BindView(R.id.shezhi_dianji)
    TextView shezhiDianji;
    @BindView(R.id.shezhi_fankui)
    TextView shezhiFankui;
    @BindView(R.id.shezhi_tuichu)
    Button shezhiTuichu;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_shezhi);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.info_shezhi,
            R.id.shezhi_anquan,
            R.id.shezhi_shezhi,
            R.id.shezhi_bofang,
            R.id.shezhi_xiaozi,
            R.id.shezhi_jiancha,
            R.id.shezhi_dianji,
            R.id.shezhi_fankui,
            R.id.shezhi_tuichu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_shezhi:
                finish();
                break;
            case R.id.shezhi_anquan:
                intent=new Intent(this,MySheZhi_AnQuan.class);
                startActivity(intent);
                break;
//            case R.id.shezhi_shezhi:
//                break;
//            case R.id.shezhi_bofang:
//                break;
//            case R.id.shezhi_xiaozi:
//                break;
//            case R.id.shezhi_jiancha:
//                break;
//            case R.id.shezhi_dianji:
//                break;
//            case R.id.shezhi_fankui:
//                break;
//            case R.id.shezhi_tuichu:
//                break;
        }
    }
}
