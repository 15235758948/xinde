package com.example.administrator.myapplication.My;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/13.
 */
public class AnQuan_ShouJi extends Activity {
    @BindView(R.id.shouji_editText1)
    EditText shoujiEditText1;
    @BindView(R.id.yanzhengma_val)
    EditText yanzhengma_val;
    @BindView(R.id.yanzhengma_img)
    ImageView yanzhengma_img;
    @BindView(R.id.yanzhengma_huan)
    Button yanzhengma_huan;
    @BindView(R.id.shouji_editText2)
    EditText shoujiEditText2;
    @BindView(R.id.btn_login_submit)
    Button submit;

    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anquan_shouji);
        ButterKnife.bind(this);
        //        验证码图片
        initImage();
//        短信验证码读秒
        initMsg();

    }

    private void initMsg() {
        time = new TimeCount(60000, 1000);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                time.start();// 开始计时
            }
        });
    }

    private void initImage() {

        yanzhengma_img.setImageBitmap(AnQuanImage.getInstance().createBitmap());

        System.out.println("验证码：" + AnQuanImage.getInstance().getCode());

        yanzhengma_huan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                yanzhengma_img.setImageBitmap(AnQuanImage.getInstance().createBitmap());
                System.out.println("验证码：" + AnQuanImage.getInstance().getCode());
            }
        });

    }

    @OnClick(R.id.anquan_bangding)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anquan_bangding:
                finish();
                break;
        }

    }

    //验证码读秒
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {// 计时完毕
            submit.setText("获取验证码");
            submit.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            submit.setClickable(false);//防止重复点击
            submit.setText(millisUntilFinished / 1000 + "s");
        }
    }
}