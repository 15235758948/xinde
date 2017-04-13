package base.toor.click.toor_xiazai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.HomeActivity;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2017/4/1.
 */
public class TitleDownActivity extends AppCompatActivity {
    @BindView(R.id.title_down_fh)
    TextView tv;
    @BindView(R.id.id_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.id_viewpager)
    ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private FragmentManager fragmentManager;
    private DownloadingFragment downloadingFragment;
    private CompletedFragment completedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toor_down);
        ButterKnife.bind(this);
        initView();
        //           隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

////        信号栏变主题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


    }

    private void initView() {
        mTitles.add("下载中");
        mTitles.add("已完成");


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        downloadingFragment = DownloadingFragment.newInstance();
        completedFragment = CompletedFragment.newInstance();
        fragmentsList.add(downloadingFragment);
        fragmentsList.add(completedFragment);

        TitleDownAdapter myPagerAdapter = new TitleDownAdapter(getSupportFragmentManager(), fragmentsList, mTitles);
        tabLayout.setSelected(true);
        tabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick(R.id.title_down_fh)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_down_fh:
               finish();
                break;
        }
    }
}
