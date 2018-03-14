package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.loader.GlideImageLoader;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.orhanobut.logger.Logger;
import com.wsq.library.views.adapter.DefaultAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class BannerFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView, ViewPager.OnPageChangeListener {

    public static final String TAG = BannerFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;


    @BindView(R.id.banner)
    Banner banner;

    @BindView(R.id.tv_title)
    TextView tv_title;

    private DefaultAdapter mAdapter;
    private List<String> mData;
    private List<String > images;
    private List<String> titles;

    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_banner;
    }

    @Override
    protected void initView() {
        mData = new ArrayList<>();
        tv_title.setText("轮播图");
        images = new ArrayList<>();
        titles = new ArrayList<>();



        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用

        banner.setOnPageChangeListener(this);

        ipresenter.showBannerData();

    }
    @OnClick(R.id.ll_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }


    @Override
    public void showData(List<String> data) {

        for (int i = 0; i < data.size(); i++) {
            titles.add("这个是第 "+i+" 张图片");
            images.add(data.get(i));
        }
        banner.setImages(images);
        banner.setBannerTitles(titles);
        banner.start();
//        banner.update(images, titles);
    }


    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Logger.d(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
