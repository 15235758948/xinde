package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.myapplication.My.MyFragment;
import com.example.administrator.myapplication.drawerLayout.Drawer_dashang;
import com.example.administrator.myapplication.drawerLayout.Drawer_friends;
import com.example.administrator.myapplication.drawerLayout.Drawer_pinLun;
import com.example.administrator.myapplication.drawerLayout.Drawer_shoucang;
import com.example.administrator.myapplication.drawerLayout.mymoney.Drawer_qianbao;
import com.example.administrator.myapplication.home.HomeFragment;
import com.example.administrator.myapplication.interest.InterestFragment;
import com.example.administrator.myapplication.more.MoreFragment;
import com.example.administrator.myapplication.movie.MovieFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import base.TextFragment;
import base.toor.click.Toor_gengduo;
import base.toor.click.Toor_xiaoxitx;
import base.toor.click.toor_sousuo.TitleSeekActivity;
import base.toor.click.toor_xiazai.TitleDownActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/3/17.
 */

public class HomeActivity extends Activity implements OnTabSelectListener, NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.bottom_bar)
    BottomBar mbottomBar;
    @BindView(R.id.image_xiaoxitx)
    ImageView imageXiaoxitx;
    @BindView(R.id.image_ceshi3)
    ImageView imageCeshi3;
    @BindView(R.id.image_xaizai)
    ImageView imageXaizai;
    @BindView(R.id.image_gengduo)
    ImageView imageGengduo;
    @BindView(R.id.image_chakan)
    ImageView imageChakan;
    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.navigationview)
    NavigationView navigationview;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;


    private HomeFragment mHomeFragment;
    private MovieFragment mImFragment;
    private MoreFragment mMoreFragment;
    private InterestFragment mInterestFragment;
    private MyFragment mUserFragment;
    private Fragment mCurrentFragment;
    private Unbinder bind;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bind = ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
//        信号栏变主题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        左上角的侧滑
//        inSlidingMenu();
//        底部导航
        ininview();
//        抽屉
        ininDrawer();
        initDrawLayout();
//        头布局里的点击事件
        navigationview.setNavigationItemSelectedListener(this);
    }

    // toor的点击跳转
    @OnClick({R.id.image_ceshi3, R.id.image_gengduo, R.id.image_xaizai, R.id.image_chakan, R.id.image_xiaoxitx})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_ceshi3:
                if (!drawerlayout.isDrawerOpen(navigationview)) {
                    drawerlayout.openDrawer(navigationview);
                }
                break;
            case R.id.image_gengduo:
                intent = new Intent(this, Toor_gengduo.class);
                startActivity(intent);
                break;
            case R.id.image_xaizai:
                intent = new Intent(this, TitleDownActivity.class);
                startActivity(intent);
                break;
            case R.id.image_chakan:
                intent=new Intent(this, TitleSeekActivity.class);
                startActivity(intent);
                break;
            case R.id.image_xiaoxitx:
                intent = new Intent(this,Toor_xiaoxitx.class);
                startActivity(intent);
                break;
        }

    }

    //抽屉的点击跳转
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.book_pingLun:
                intent = new Intent(this, Drawer_pinLun.class);
                startActivity(intent);
                break;
            case R.id.book_pengYou:
                intent = new Intent(this, Drawer_friends.class);
                startActivity(intent);
                break;
            case R.id.book_daShang:
                intent=new Intent(this, Drawer_dashang.class);
                startActivity(intent);
                break;
            case R.id.book_shouCang:
                intent=new Intent(this, Drawer_shoucang.class);
                startActivity(intent);
                break;
            case R.id.book_qianBao:
                intent=new Intent(this, Drawer_qianbao.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //抽屉的打开宽度
    private void initDrawLayout() {
        NavigationView mLl_two = (NavigationView) findViewById(R.id.navigationview);
        WindowManager wm = this.getWindowManager();//获取屏幕宽高
        int width1 = wm.getDefaultDisplay().getWidth();
        int height1 = wm.getDefaultDisplay().getHeight();
        ViewGroup.LayoutParams para = mLl_two.getLayoutParams();//获取drawerlayout的布局
        para.width = width1 / 4 * 3;//修改宽度
        para.height = height1;//修改高度
        mLl_two.setLayoutParams(para); //设置修改后的布局。

    }

    private void ininDrawer() {

//        // 关闭手势滑动
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerlayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // 打开手势滑动
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 关闭手势滑动
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }


//    private void inSlidingMenu() {
//        slidingMenu = new SlidingMenu(this);
//        slidingMenu.setMode(SlidingMenu.LEFT);
//        slidingMenu.setShadowWidth(16);
//        slidingMenu.setMenu(R.layout.activity_left);
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        slidingMenu.setBehindWidth(580);
//        slidingMenu.setTouchModeBehind(SlidingMenu.LEFT_RIGHT);
//        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        slidingMenu.setBehindScrollScale(0.35f);
//        imageCeshi3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                slidingMenu.toggle();
//            }
//        });
//
//
//    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        bind.unbind();
//    }


    //视图的初始化
    private void ininview() {
//        设置导航的监听事件
        retrieverFragement();
        mbottomBar.setOnTabSelectListener(this);
    }

    //    底部导航栏某一项选择的时候触发
    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                }
//                切换
                switchfragment(mHomeFragment);
                break;
            case R.id.tab_im:
                if (mImFragment == null) {
                    mImFragment = MovieFragment.newInstance();
                }
                switchfragment(mImFragment);
                break;
            case R.id.tab_more:
                if (mMoreFragment == null) {
                    mMoreFragment = MoreFragment.newInstance();
                }
                switchfragment(mMoreFragment);
                break;
            case R.id.tab_interest:
                if (mInterestFragment == null) {
                    mInterestFragment = InterestFragment.newInstance();
                }
                switchfragment(mInterestFragment);
                break;
            case R.id.tab_user:
                if (mUserFragment == null) {
                    mUserFragment = MyFragment.newInstance();
                }
                switchfragment(mUserFragment);
                break;
            default:
                throw new UnsupportedOperationException("unsunpport");
        }
    }

    //    切换
    private void switchfragment(Fragment target) {
//     add   show  hide的方式
        if (mCurrentFragment == target) return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (target.isAdded()) {
            transaction.show(target);
        } else {
            String tag;
            if (target instanceof TextFragment) {
                tag = ((TextFragment) target).getArgumentText();
            } else {
                tag = target.getClass().getName();
            }
            transaction.add(R.id.layout_container, target, tag);
        }
        transaction.commit();
        mCurrentFragment = target;

    }

    //    恢复因为系统重启造成的Fragementmanager里面恢复的Fragment
    private void retrieverFragement() {
        FragmentManager manager = getFragmentManager();
        mHomeFragment = (HomeFragment) manager.findFragmentByTag(HomeFragment.class.getName());
        mImFragment = (MovieFragment) manager.findFragmentByTag(MovieFragment.class.getName());
        mMoreFragment = (MoreFragment) manager.findFragmentByTag(MoreFragment.class.getName());
        mInterestFragment = (InterestFragment) manager.findFragmentByTag(InterestFragment.class.getName());
        mUserFragment = (MyFragment) manager.findFragmentByTag(MyFragment.class.getName());
    }

    @Override
    public void onBackPressed() {
//        抽屉打开时，点击返回键关闭抽屉
        if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
            drawerlayout.closeDrawer(Gravity.LEFT);
            return;
        }
        if (mCurrentFragment != mHomeFragment) {
//            如果不是首页，就切换到首页上
            mbottomBar.selectTabWithId(R.id.tab_home);
            return;
        } else {
//            是首页，不去关闭，退到后台运行
            moveTaskToBack(true);
        }
    }
}
