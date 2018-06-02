package com.wsq.library.views.popup;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.example.wlibrary.R;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.dao.CityDao;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.AppManager;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.CityAdapter;
import com.wsq.library.views.listener.OnCityResultCallBack;

import java.util.ArrayList;
import java.util.List;

public class CityPopup extends PopupWindow implements RadioGroup.OnCheckedChangeListener {

    private Activity mContext;
    private OnCityResultCallBack mCallBack;
    private View popupView;
    private RadioGroup rg_area;
    private RadioButton rb_province, rb_city, rb_county;
    private TextView  tv_ok;

    private RecyclerView rv_RecyclerView;


    private CityAdapter mAdapter;

    private List<CityInfoBean> mData; //所有的数据
    private List<CityInfoBean> mListProvince; //省
    private List<CityInfoBean> mListCity;  //市
    private List<CityInfoBean> mListCounty;  //县区
    private List<CityInfoBean> mCurList;  //县区
    private int curType=0;  //0 省 1城市 2县区
    private CityInfoBean curProvince;
    private CityInfoBean curCity;
    private CityInfoBean curCounty;

    private CityDao cityDao;


    public CityPopup(Activity context, OnCityResultCallBack cityResultCallBack){
        this.mContext = context;
        this.mCallBack = cityResultCallBack;

        popupView = LayoutInflater.from(mContext).inflate(R.layout.layout_popup_city,null, false);

        cityDao = new CityDao(mContext, AppManager.getAppPackageName());
        onInitWheelView();
        initPopup();
    }

    public void initPopup(){

        int w = mContext.getResources().getDisplayMetrics().widthPixels;
        int h = mContext.getResources().getDisplayMetrics().heightPixels;
        // 设置按钮监听
        // 设置SelectPicPopupWindow的View
        this.setContentView(popupView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w);
        //
        // 设置SelectPicPopupWindow弹出窗体的高
        int height = DensityUtil.dp2px(mContext, 45+30*6 + 20 +40);
        this.setHeight(height);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.style_pop);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        this.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

//        this.setOnDismissListener(new PoponDismissListener());

        popupView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

//					dismiss();

                return false;
            }
        });

    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        backgroundAlpha(0.5f);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        backgroundAlpha(1f);
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = mContext.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        mContext.getWindow().setAttributes(lp);
    }

    private void onInitWheelView(){

        rg_area = popupView.findViewById(R.id.rg_area);
        rb_province = popupView.findViewById(R.id.rb_province);
        rb_city = popupView.findViewById(R.id.rb_city);
        rb_county = popupView.findViewById(R.id.rb_county);
        rv_RecyclerView = popupView.findViewById(R.id.rv_RecyclerView);
        tv_ok = popupView.findViewById(R.id.tv_ok);

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                mContext, LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(mContext, 1),
                ContextCompat.getColor(mContext, R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        rv_RecyclerView.setHasFixedSize(true);
        rv_RecyclerView.setNestedScrollingEnabled(false);
        rb_province.setChecked(true);
        rg_area.setOnCheckedChangeListener(this);



        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack();
            }
        });


        onInitData();
        onGetProvince();
        mAdapter = new CityAdapter(mContext, mCurList, listener);
        rv_RecyclerView.setAdapter(mAdapter);

    }

    OnRecyclerViewItemClickListener listener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {

            switch (curType){
                case 0:
                    onGetCityData(mListProvince.get(position).getId());
                    curProvince = mListProvince.get(position);
                    rb_city.setChecked(true);
                    break;
                case 1:
                    onGetCountyData(mListCity.get(position).getId());
                    curCity = mListCity.get(position);
                    rb_county.setChecked(true);
                    break;
                case 2:
                        curCounty = mListCounty.get(position);
                       onCallBack();
                    break;
            }
        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {

        }
    };
    /**
     * 初始化数据
     */
    private void onInitData(){

        mData = new ArrayList<>();
        mCurList = new ArrayList<>();
        mListProvince = new ArrayList<>();
        mListCity = new ArrayList<>();
        mListCounty = new ArrayList<>();

        mData.addAll(cityDao.getData(-1));
    }

    /**
     * 获取省
     */
    private void onGetProvince(){

        for (int i = 0; i < mData.size(); i++) {
            int parent_id = mData.get(i).getParent_id();
            if (parent_id ==-1){
                mListProvince.add(mData.get(i));
            }
        }
        curType =0;
        mCurList.addAll(mListProvince);


    }

    /**
     * 获取城市
     */
    private synchronized void onGetCityData(int parent_id){

        mListCity.clear();
        for (int i = 0; i < mData.size(); i++) {
            int id = mData.get(i).getParent_id();
            if (id == parent_id){
                mListCity.add(mData.get(i));
            }
        }
        if (mListCity.size() == 0){
            ToastUtils.onToast("没有下一级");
        }else{
            curType =1;
            mCurList.clear();
            mCurList.addAll(mListCity);
            mAdapter.notifyDataSetChanged();
        }

    }

    /**
     * 获取县区
     * @param parent_id
     */
    private synchronized void onGetCountyData(int parent_id){

        mListCounty.clear();
        for (int i = 0; i < mData.size(); i++) {
            int id = mData.get(i).getParent_id();
            if (id == parent_id){
                mListCounty.add(mData.get(i));
            }
        }
        if (mListCounty.size() == 0){
            ToastUtils.onToast("没有下一级");
        }else{
            curType =2;
            mCurList.clear();
            mCurList.addAll(mListCounty);
            mAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

        if (checkId== rb_province.getId()){
            curType = 0 ;
            mCurList.clear();
            mCurList.addAll(mListProvince);
        }else if(checkId == rb_city.getId()){

            if (mListCity.size() > 0){
                curType = 1 ;
                mCurList.clear();
                mCurList.addAll(mListCity);
            }else {
                ToastUtils.onToast("请选择省份");
            }

        }else if(checkId == rb_county.getId()){
            if (mListCounty.size() > 0){
                curType = 2 ;
                mCurList.clear();
                mCurList.addAll(mListCounty);
            }else {
                ToastUtils.onToast("请选择城市");
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    private void onCallBack(){

        if (curProvince == null){
            ToastUtils.onToast("请选择省份");
            return;
        }


//        if (curCity == null){
//            ToastUtils.onToast("请选择城市");
//            return;
//        }
//
//        if (curCounty == null){
//            ToastUtils.onToast("请选择区县");
//            return;
//        }
        if (mCallBack != null){
            mCallBack.onCallBack(curProvince, curCity, curCounty);
        }
        dismiss();
    }
}
