package com.example.administrator.myapplication.movie;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.FragmentAdapter;
import com.example.administrator.myapplication.home.FragmentTwoAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import base.widgets.banner.BannerAdapter;
import base.widgets.banner.BannerLayout;
import base.widgets.banner.LocalBanner;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MovieFragment extends Fragment {
    @BindView(R.id.layout_banner)
    BannerLayout mLayoutBanner;
    @BindView(R.id.list_wen)
    ListView listWen;
    @BindView(R.id.list_quan)
    GridView listQuan;

    //    Integer[] imageIds = new Integer[]{
//            R.drawable.page1, R.drawable.page2, R.drawable.page3, R.drawable.page4,
//    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        initView();
        initList();
        initViewQ();
        return view;
    }

    private void initView() {
//        给LayoutBanner设置适配器
        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {
            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getActivity()).load(data.getLocalRes()).into(holder.mImageView);
            }

        };
        mLayoutBanner.setAdapter(bannerAdapter);
        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.page1));
        localBanners.add(new LocalBanner(R.drawable.page2));
        localBanners.add(new LocalBanner(R.drawable.page3));
        localBanners.add(new LocalBanner(R.drawable.page4));
        bannerAdapter.reset(localBanners);
    }

    private void initList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("画江湖之不良人");
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getActivity(), list);
        listWen.setAdapter(fragmentAdapter);
    }

    private void initViewQ() {

        List<Integer[]> list = new ArrayList<>();
        Integer[] imageIds = new Integer[]{
                R.drawable.page3,
        };
        for (int i = 0; i < 8; i++) {
            list.add(imageIds);
        }
        FragmentTwoAdapter fragmentTwoAdapter = new FragmentTwoAdapter(getActivity(), list);
        listQuan.setAdapter(fragmentTwoAdapter);


    }

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }
}
