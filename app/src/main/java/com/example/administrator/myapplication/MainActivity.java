package com.example.administrator.myapplication;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends Activity implements Animator.AnimatorListener {

    @BindView(R.id.image_main)
    ImageView imageMain;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        不显示标题
//        AppCompatActivity activity= (AppCompatActivity) getApplicationContext();
//        ActionBar actionBar=activity.getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
        //绑定Butterknife
        unbinder = ButterKnife.bind(this);

        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
////        信号栏变主题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////        信号栏变主题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //完成视图的操作
        initView();

    }

    private void initView() {
        //属性动画来完成：ViewProperAnimator针对于view操作的动画类
        imageMain.setAlpha(0.3f);
        imageMain.animate()
                .alpha(1.0f)
//                .scaleX(0.9f)
                .setDuration(2000)
                .setListener(this)
                .start();

    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
//        设置转场的效果
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
        finish();

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    //动画重复播放
    @Override
    public void onAnimationRepeat(Animator animation) {


    }
}
