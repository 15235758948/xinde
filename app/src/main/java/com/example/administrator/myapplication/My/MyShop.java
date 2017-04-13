package com.example.administrator.myapplication.My;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.drawerLayout.AdapterShopShoucang;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import base.widgets.banner.BannerAdapter;
import base.widgets.banner.BannerLayout;
import base.widgets.banner.LocalBanner;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/10.
 */
public class MyShop extends AppCompatActivity {
    @BindView(R.id.layout_banner)
    BannerLayout layoutBanner;
    @BindView(R.id.list_shopview1)
    GridView listShopview1;
    @BindView(R.id.list_shopview2)
    GridView listShopview2;
    @BindView(R.id.list_shopview3)
    GridView listShopview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_shop);
        ButterKnife.bind(this);
        //        轮播图的初始化
        initBanner();
//        促销商品
        initList();
        //        隐藏Actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void initBanner() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {

            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getApplicationContext()).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        layoutBanner.setAdapter(bannerAdapter);
        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.page1));
        localBanners.add(new LocalBanner(R.drawable.page2));
        localBanners.add(new LocalBanner(R.drawable.page3));
        localBanners.add(new LocalBanner(R.drawable.page4));
        bannerAdapter.reset(localBanners);
    }

    private void initList() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 5; i++) {
            list.add("画江湖之不良人解释道海股份的撒谎...");
        }
        AdapterShopShoucang adapterShopShoucang = new AdapterShopShoucang(this, list);
        listShopview1.setAdapter(adapterShopShoucang);
        listShopview2.setAdapter(adapterShopShoucang);
        listShopview3.setAdapter(adapterShopShoucang);
    }

    @OnClick(R.id.info_shop)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_shop:
                finish();
                break;
        }
    }
}
