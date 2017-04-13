package com.example.administrator.myapplication.My;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/11.
 */

public class DailyTopicTwoActivity extends AppCompatActivity {
    @BindView(R.id.dailytopictwo_1)
    TextView dailytopictwo1;
    @BindView(R.id.dailytopictwo_2)
    TextView dailytopictwo2;
    @BindView(R.id.dailytopictwo_3)
    TextView dailytopictwo3;
    @BindView(R.id.imageView_cuo_1)
    ImageView imageViewCuo1;
    @BindView(R.id.imageView_cuo_2)
    ImageView imageViewCuo2;
    @BindView(R.id.imageView_cuo_3)
    ImageView imageViewCuo3;
    private String num1;
    private String num2;
    private String num3;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.dailytopictwo_activity);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        intent = getIntent();
        num1 = intent.getStringExtra("1");
        num2 = intent.getStringExtra("2");
        num3 = intent.getStringExtra("3");
        dailytopictwo1.setText(num1);
        dailytopictwo2.setText(num2);
        dailytopictwo3.setText(num3);
    }

    @OnClick(R.id.mydaily_2_fh)
    public void onViewClicked() {
        finish();
    }
}
