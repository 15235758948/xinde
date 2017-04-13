package com.example.administrator.myapplication.My;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2017/4/10.
 */
public class DailyTopicActivity extends AppCompatActivity {
    @BindView(R.id.mydaily_a)
    TextView mydailyA;
    @BindView(R.id.mydaily_b)
    TextView mydailyB;
    @BindView(R.id.mydaily_c)
    TextView mydailyC;
    @BindView(R.id.mydaily_d)
    TextView mydailyD;
    private Intent intent;
    String text_a_1 = "很遗憾，答错了";
    String text_a_2 = "获得5个积分";
    String text_a_3 = "明天再来吧";
    String text_b_1 = "恭喜你，答对了";
    String text_b_2 = "获得20个积分";
    String text_b_3 = "再接再厉";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.dailytopic_activity);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.mydaily_1_fh, R.id.mydaily_a, R.id.mydaily_b, R.id.mydaily_c, R.id.mydaily_d})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mydaily_1_fh:
                finish();
                break;
            case R.id.mydaily_a:
                intent = new Intent();
                intent.putExtra("1",text_a_1);
                intent.putExtra("2",text_a_2);
                intent.putExtra("3",text_a_3);
                intent.setClass(DailyTopicActivity.this,DailyTopicTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.mydaily_b:
                intent = new Intent();
                intent.putExtra("1",text_b_1);
                intent.putExtra("2",text_b_2);
                intent.putExtra("3",text_b_3);
                intent.setClass(DailyTopicActivity.this,DailyTopicTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.mydaily_c:
                intent = new Intent();
                intent.putExtra("1",text_a_1);
                intent.putExtra("2",text_a_2);
                intent.putExtra("3",text_a_3);
                intent.setClass(DailyTopicActivity.this,DailyTopicTwoActivity.class);
                startActivity(intent);

                break;
            case R.id.mydaily_d:
                intent = new Intent();
                intent.putExtra("1",text_a_1);
                intent.putExtra("2",text_a_2);
                intent.putExtra("3",text_a_3);
                intent.setClass(DailyTopicActivity.this,DailyTopicTwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
