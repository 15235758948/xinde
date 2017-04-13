package com.example.administrator.myapplication.My;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.drawerLayout.Drawer_shoucangShop;
import com.example.administrator.myapplication.drawerLayout.Drawer_shoucangWen;
import com.example.administrator.myapplication.drawerLayout.Drawer_shoucangmovie;

import java.util.ArrayList;

import base.toor.click.toor_xiazai.TitleDownAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/10.
 */
public class MyBuy extends AppCompatActivity{
    @BindView(R.id.drawer_wodeshoucang)
    TextView drawerWodeshoucang;
    @BindView(R.id.id_playlayout)
    TabLayout idPlaylayout;
    @BindView(R.id.id_playviewpager)
    ViewPager idPlayviewpager;

    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private BuyAll buyAll;
    private BuyFuKuan buyFuKuan;
    private BuyFaHuo buyFaHuo;
    private BuyShouHuo buyShouHuo;
    private BuyPingJia buyPingJia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_buy);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTitles.add("全部");
        mTitles.add("待付款");
        mTitles.add("待发货");
        mTitles.add("待收货");
        mTitles.add("待评价");


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        buyAll = BuyAll.newInstance();
        buyFuKuan=BuyFuKuan.newInstance();
        buyFaHuo = BuyFaHuo.newInstance();
        buyShouHuo=BuyShouHuo.newInstance();
        buyPingJia=BuyPingJia.newInstance();
        fragmentsList.add(buyAll);
        fragmentsList.add(buyFuKuan);
        fragmentsList.add(buyFaHuo);
        fragmentsList.add(buyShouHuo);
        fragmentsList.add(buyPingJia);

        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentsList, mTitles);
        idPlaylayout.setSelected(true);
        idPlaylayout.setTabsFromPagerAdapter(myPagerAdapter);
        idPlayviewpager.setAdapter(myPagerAdapter);
        idPlaylayout.setupWithViewPager(idPlayviewpager);


        idPlaylayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                idPlayviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick(R.id.drawer_wodeshoucang)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_wodeshoucang:
                finish();
                break;
        }
    }
}
