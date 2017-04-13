package com.example.administrator.myapplication.drawerLayout;

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

import java.util.ArrayList;

import base.toor.click.toor_xiazai.TitleDownAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Drawer_shoucang extends AppCompatActivity {
    @BindView(R.id.drawer_wodeshoucang)
    TextView drawerWodeshoucang;
    @BindView(R.id.id_playlayout)
    TabLayout idPlaylayout;
    @BindView(R.id.id_playviewpager)
    ViewPager idPlayviewpager;
    @BindView(R.id.drawer_shoucang)
    LinearLayout drawerShoucang;

    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private Drawer_shoucangmovie drawermoviefragment;
    private Drawer_shoucangWen drawerwenfragment;
    private Drawer_shoucangShop drawerShoucangShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_shoucang);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTitles.add("影视收藏");
        mTitles.add("文章收藏");
        mTitles.add("商品收藏");


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        drawermoviefragment = Drawer_shoucangmovie.newInstance();
        drawerwenfragment = Drawer_shoucangWen.newInstance();
        drawerShoucangShop=Drawer_shoucangShop.newInstance();
        fragmentsList.add(drawermoviefragment);
        fragmentsList.add(drawerwenfragment);
        fragmentsList.add(drawerShoucangShop);

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
