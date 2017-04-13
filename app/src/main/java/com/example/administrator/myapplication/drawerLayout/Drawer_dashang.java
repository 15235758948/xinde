package com.example.administrator.myapplication.drawerLayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.myapplication.R;
import java.util.ArrayList;
import base.toor.click.toor_xiazai.TitleDownAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Drawer_dashang extends AppCompatActivity {

    @BindView(R.id.drawer_dashang)
    TextView drawerDashang;
    @BindView(R.id.id_playlayout)
    TabLayout idPlaylayout;
    @BindView(R.id.id_playviewpager)
    ViewPager idPlayviewpager;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private Drawerdafragment drawerdafragment;
    private Drawershangfragment drawershangfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_dashang);
        ButterKnife.bind(this);
        //        隐藏Actionbar
        if (getSupportActionBar()!= null) {
            getSupportActionBar().hide();
        }

        initView();

    }
    private void initView() {
        mTitles.add("我的打赏");
        mTitles.add("打赏我的");


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        drawerdafragment = Drawerdafragment.newInstance();
        drawershangfragment = Drawershangfragment.newInstance();
        fragmentsList.add(drawerdafragment);
        fragmentsList.add(drawershangfragment);

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

    @OnClick(R.id.drawer_dashang)
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.drawer_dashang:
                finish();
                break;
        }
    }
}
