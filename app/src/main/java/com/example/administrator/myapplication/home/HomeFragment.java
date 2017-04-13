package com.example.administrator.myapplication.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import base.widgets.banner.BannerAdapter;
import base.widgets.banner.BannerLayout;
import base.widgets.banner.LocalBanner;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/3/22.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.list_wen)
    ListView listwen;
    @BindView(R.id.layout_banner)
    BannerLayout bannerLayout;
    //    @BindView(R.id.vp)
//    ViewPager mViewPager;
//    @BindView(R.id.tv)
//    TextView title;
//    private ViewPaperAdapter mAdapter;
//    //    存放图片集合
//    private List<ImageView> imageViews;
//    //    图片描述集合
//    private String[] titles = new String[]{"变形金刚", "某某猎人", "加勒比海盗", "海洋的心"};
//    //    存放小点集合
//    private List<TextView> dots;
////        存放图片id的集合
//    Integer[] imageIds = new Integer[]{
//            R.drawable.page1,
//            R.drawable.page2,
//            R.drawable.page3,
//            R.drawable.page4,
//    };
    @BindView(R.id.list_quan)
    GridView listQuan;
    //    线程池，用来自动轮播
//    private ScheduledExecutorService scheduledExecutorService;
//    private int currentItem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
//        轮播图的初始化
        initBanner();
//        initgetHomeData();
//        画江湖之不良人的list
        initView();
//        拳头热点资讯的List
        initViewQ();
//        轮播
//        initMovie();
        return view;
    }


    private void initBanner() {

        BannerAdapter<LocalBanner> bannerAdapter = new BannerAdapter<LocalBanner>() {

            @Override
            protected void bind(ViewHolder holder, LocalBanner data) {
                Picasso.with(getActivity()).load(data.getLocalRes()).into(holder.mImageView);
            }
        };
        bannerLayout.setAdapter(bannerAdapter);

        List<LocalBanner> localBanners = new ArrayList<>();
        localBanners.add(new LocalBanner(R.drawable.page1));
        localBanners.add(new LocalBanner(R.drawable.page2));
        localBanners.add(new LocalBanner(R.drawable.page3));
        localBanners.add(new LocalBanner(R.drawable.page4));
        bannerAdapter.reset(localBanners);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
//}
//    private void initgetHomeData(){
//        BannerDataPicture bannerDataPicture=new BannerDataPicture();
//        Log.e(""+bannerDataPicture,"22222");
//        bannerAdapter.reset(bannerDataPicture.getData().getPictureList());
//
//    }

//    private void initView() {
//        //                holder.mImageView.setImageResource(R.drawable.page1);
//        bannerAdapter = new BannerAdapter<Banner>() {
//            @Override
//            protected void bind(ViewHolder holder, Object data) {
////                Integer[] imageIds = new Integer[]{
////                        R.drawable.page1,
////                        R.drawable.page2,
////                        R.drawable.page3,
////                        R.drawable.page4,
////                };
////                Picasso.with(getContext()).load(imageIds).into(holder.mImageView);
//
//            }
//        };
//        bannerLayout.setAdapter(bannerAdapter);
//
////        给LayoutBanner设置适配器
////        bannerAdapter = new BannerAdapter<BannerDataPicture>() {
////            @Override
////            protected void bind(ViewHolder holder, BannerDataPicture data) {
////
////               holder.mImageView.setImageResource(R.drawable.page1);
////
////            }
////        };
////        mLayoutBanner.setAdapter(bannerAdapter);
////        添加模拟数据
//
//        List<BannerDataPicture> data=new ArrayList<>();
//        BannerDataPicture object=new BannerDataPicture();
//        data.add(object);
//        data.add(new BannerDataPicture());
//        data.add(new BannerDataPicture());
//        data.add(new BannerDataPicture());
//        bannerAdapter.reset(data);
//    }

    private void initView() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("画江湖之不良人");
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getActivity(), list);
        listwen.setAdapter(fragmentAdapter);
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

}


//     class FragmentAdapter extends BaseAdapter {
//    private Context context;
//    private List<String> list = new ArrayList<String>();
//    public FragmentAdapter(Context context, List<String> list) {
//        this.context = context;
//        this.list = list;
//
//    }
//
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder =null;
//        if (convertView==null){
//            holder = new ViewHolder();
//            convertView = LayoutInflater.from(context).inflate(R.layout.itm_text,null);
//            holder.tv = (TextView) convertView.findViewById(R.id.info_tx);
//            convertView.setTag(holder);
//
//        }else {
//            holder= (ViewHolder) convertView.getTag();
//        }
//        holder.tv.setText(list.get(position).toString());
//
//
//        return convertView;
//    }
//    private class ViewHolder{
//        TextView tv;
//    }
//}
//    private void initMovie() {
//        //        显示图片的集合
//        imageViews = new ArrayList<>();
//        for (int i = 0; i < imageIds.length; i++) {
//            ImageView imageView = new ImageView(getContext());
//            imageView.setBackgroundResource(imageIds[i]);
//            imageViews.add(imageView);
////            显示小点点的集合
//        dots = new ArrayList<>();
//        dots.add((TextView) findViewById(R.id.dot_0));
////        dots.add((TextView) findViewById(R.id.dot_1));
////        dots.add((TextView) findViewById(R.id.dot_2));
////        dots.add((TextView) findViewById(R.id.dot_3));
////            刚进来默认显示第一张图
//            dots.get(0).setBackgroundResource(R.drawable.dot_focesed);
//            title.setText(titles[0]);
//
//            mAdapter = new ViewPaperAdapter();
//            mViewPager.setAdapter(mAdapter);
////            关于小点点图片标题的改变
//            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                }
//
//                @Override
//                public void onPageSelected(int position) {
////                    标题的改变
//                    title.setText(titles[position]);
////                    小点点的改变
//                    for (int i = 0; i < imageIds.length; i++) {
//                        dots.get(i).setBackgroundResource(R.drawable.dot_normal);
//                    }
//                    dots.get(position).setBackgroundResource(R.drawable.dot_focesed);
////                    用于用户手动滑动轮播图的处理
//                    currentItem = position;
//                }
//
//                @Override
//                public void onPageScrollStateChanged(int state) {
//
//                }
//            });
//        }
//        }
//
//    @Override
//    public void onStart() {
//        super.onStart();
////        开启一个单独的后台线程
//        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleWithFixedDelay(new ViewPaperTask(), 3, 3, TimeUnit.SECONDS);
//    }
//
//    private class ViewPaperTask implements Runnable {
//
//        @Override
//        public void run() {
////            确定跳转到哪一个页面，用取余方式来确定
//            currentItem = (currentItem + 1) % imageIds.length;
//            mhandler.sendEmptyMessage(0);
//
//        }
//    }
//
//    public Handler mhandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            mViewPager.setCurrentItem(currentItem);
//        }
//    };
//
//
//        class ViewPaperAdapter extends PagerAdapter {
//            @Override
//            public int getCount() {
//                return imageViews.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//            //return一个对象，表明PaperAdapter适配器选择哪个对象放入ViewPaper中
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(imageViews.get(position));
//                return imageViews.get(position);
//            }
//
//            //从Viewgroup中移除当前的view
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView(imageViews.get(position));
//            }
//        }
