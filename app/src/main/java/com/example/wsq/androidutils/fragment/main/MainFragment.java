package com.example.wsq.androidutils.fragment.main;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.fragment.main.tab.OneTabFragment;
import com.example.wsq.androidutils.fragment.main.tab.ThreeTabFragment;
import com.example.wsq.androidutils.fragment.main.tab.TwoTabFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

/**
 * Created by wsq on 2018/1/23.
 */

public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener {


    public static final String TAG = MainFragment.class.getName();
    public static final String INTERFACE = TAG ;


    @BindView(R.id.vp_ViewPager) ViewPager vp_ViewPager;
    @BindView(R.id.magic_indicator) MagicIndicator magic_indicator;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.ll_back) LinearLayout ll_back;

    private String[] titles = new String[]{"功能", "view", "测试"};
    private Fragment[] fragments = new Fragment[3];

    private MyAdapter adapter;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_fragment_main;
    }

    @Override
    public void initView() {

        ll_back.setVisibility(View.GONE);
        fragments[0] = new OneTabFragment();
        fragments[1] = new TwoTabFragment();
        fragments[2] = new ThreeTabFragment();

        tv_title.setText(titles[0]);
        initMagicIndicator();
        adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        vp_ViewPager.setAdapter(adapter);
        vp_ViewPager.addOnPageChangeListener(this);
        vp_ViewPager.setCurrentItem(0);

    }
    private void initMagicIndicator() {
        magic_indicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);  //ture 即标题平分屏幕宽度的模式
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles == null ? 0 : titles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles[index]);
                simplePagerTitleView.setTextSize(18);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(Color.BLACK);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_ViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                //圆点
//                BezierPagerIndicator indicator = new BezierPagerIndicator(context);
//                indicator.setColors(Color.parseColor("#ff4a42"), Color.parseColor("#fcde64"), Color.parseColor("#73e8f4"), Color.parseColor("#76b0ff"), Color.parseColor("#c683fe"));

                //线条
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#ff4a42"));
                indicator.setMode(LinePagerIndicator.MODE_MATCH_EDGE);
                return indicator;
            }
        });
        magic_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magic_indicator, vp_ViewPager);
    }

    @OnClick({R.id.ll_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ll_back:
                    getActivity().getSupportFragmentManager().popBackStack();
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

        tv_title.setText(titles[i]);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
