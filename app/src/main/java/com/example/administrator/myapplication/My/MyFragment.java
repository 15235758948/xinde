package com.example.administrator.myapplication.My;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.drawerLayout.Drawer_friends;
import com.example.administrator.myapplication.drawerLayout.Drawer_pinLun;
import com.example.administrator.myapplication.drawerLayout.Drawer_shoucang;

import base.toor.click.toor_xiazai.TitleDownActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MyFragment extends Fragment {


    @BindView(R.id.my_xiaoxi)
    TextView myXiaoxi;
    @BindView(R.id.my_guankan)
    TextView myGuankan;
    @BindView(R.id.my_huancun)
    TextView myHuancun;
    @BindView(R.id.my_shoucang)
    TextView myShoucang;
    @BindView(R.id.my_dingyue)
    TextView myDingyue;
    @BindView(R.id.my_quanzi)
    TextView myQuanzi;
    @BindView(R.id.my_friends)
    TextView myFriends;
    @BindView(R.id.my_shangcheng)
    TextView myShangcheng;
    @BindView(R.id.my_qianbao)
    TextView myQianbao;
    @BindView(R.id.my_dingdan)
    TextView myDingdan;
    @BindView(R.id.my_shezhi)
    TextView myShezhi;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        ButterKnife.bind(this, view);
        return view;
    }

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @OnClick({R.id.my_xiaoxi,
            R.id.my_guankan,
            R.id.my_huancun,
            R.id.my_shoucang,
            R.id.my_dingyue,
            R.id.my_quanzi,
            R.id.my_friends,
            R.id.my_shangcheng,
            R.id.my_qianbao,
            R.id.my_dingdan,
            R.id.my_shezhi,
            R.id.imageView5,
            R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_xiaoxi:
                intent = new Intent(getActivity(), Drawer_pinLun.class);
                startActivity(intent);
                break;
            case R.id.my_guankan:
                intent = new Intent(getActivity(), MySeeHistory.class);
                startActivity(intent);
                break;
            case R.id.my_huancun:
                intent = new Intent(getActivity(), TitleDownActivity.class);
                startActivity(intent);
                break;
            case R.id.my_shoucang:
                intent = new Intent(getActivity(), Drawer_shoucang.class);
                startActivity(intent);
                break;
            case R.id.my_dingyue:
                intent = new Intent(getActivity(), MyDingYue.class);
                startActivity(intent);
                break;
            case R.id.my_quanzi:
                intent = new Intent(getActivity(), MyQuanZi.class);
                startActivity(intent);
                break;
            case R.id.my_friends:
                intent = new Intent(getActivity(), Drawer_friends.class);
                startActivity(intent);
                break;
            case R.id.my_shangcheng:
                intent = new Intent(getActivity(), MyShop.class);
                startActivity(intent);
                break;
            case R.id.my_qianbao:
                break;
            case R.id.my_dingdan:
                intent = new Intent(getActivity(), MyBuy.class);
                startActivity(intent);
                break;
            case R.id.my_shezhi:
                intent = new Intent(getActivity(), MySheZhi.class);
                startActivity(intent);
                break;
//            我的页面，点击头像
            case R.id.imageView5:
                intent=new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
                break;
//            我的页面，每日任务
            case  R.id.textView2:
                intent=new Intent(getActivity(),DailyTopicActivity.class);
                startActivity(intent);
                break;
        }
    }
}
