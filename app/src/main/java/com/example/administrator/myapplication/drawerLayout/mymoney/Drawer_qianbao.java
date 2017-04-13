package com.example.administrator.myapplication.drawerLayout.mymoney;

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

public class Drawer_qianbao extends AppCompatActivity {


    @BindView(R.id.drawer_wodeqianbao)
    TextView drawerWodeqianbao;
    @BindView(R.id.id_playlayout)
    TabLayout idPlaylayout;
    @BindView(R.id.id_playviewpager)
    ViewPager idPlayviewpager;
    @BindView(R.id.drawer_qianbao)
    LinearLayout drawerQianbao;

    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private Drawer_qianbaoJiFen jifenfragment;
    private Drawer_qianbaoYuE yuefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_qianbao);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTitles.add("积分 1216分");
        mTitles.add("余额 12568");


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        jifenfragment = Drawer_qianbaoJiFen.newInstance();
        yuefragment = Drawer_qianbaoYuE.newInstance();
        fragmentsList.add(jifenfragment);
        fragmentsList.add(yuefragment);

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

    @OnClick(R.id.drawer_wodeqianbao)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_wodeqianbao:
                finish();
                break;
        }
    }
}
