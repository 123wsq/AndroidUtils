package com.example.wsq.androidutils.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseActivity;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.bean.UserBean;
import com.example.wsq.androidutils.fragment.TabFragment;
import com.example.wsq.androidutils.fragment.main.MainFragment;
import com.example.wsq.androidutils.fragment.main.custom.AmountFragment;
import com.example.wsq.androidutils.fragment.main.custom.AnimatorFragment;
import com.example.wsq.androidutils.fragment.main.custom.BannerFragment;
import com.example.wsq.androidutils.fragment.main.custom.CanvasBitmapFragment;
import com.example.wsq.androidutils.fragment.main.custom.CityFragment;
import com.example.wsq.androidutils.fragment.main.custom.CitySearchFragment;
import com.example.wsq.androidutils.fragment.main.custom.CustomControlFragment;
import com.example.wsq.androidutils.fragment.main.custom.DataValidateFragment;
import com.example.wsq.androidutils.fragment.main.custom.DbFragment;
import com.example.wsq.androidutils.fragment.main.custom.DesignPatternFragment;
import com.example.wsq.androidutils.fragment.main.custom.DialogFragment;
import com.example.wsq.androidutils.fragment.main.custom.EditTextFragment;
import com.example.wsq.androidutils.fragment.main.custom.ImageFragment;
import com.example.wsq.androidutils.fragment.main.custom.IndexFragment;
import com.example.wsq.androidutils.fragment.main.custom.MediaFragment;
import com.example.wsq.androidutils.fragment.main.custom.ReflectFragment;
import com.example.wsq.androidutils.fragment.main.custom.RefreshFragment;
import com.example.wsq.androidutils.fragment.main.custom.WaterFragment;
import com.example.wsq.androidutils.fragment.main.tab.OneTabFragment;
import com.example.wsq.androidutils.fragment.main.tab.ThreeTabFragment;
import com.example.wsq.androidutils.fragment.main.tab.TwoTabFragment;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.struct.FunctionNoParamNoResult;
import com.wsq.library.struct.FunctionWithParamAndResult;
import com.wsq.library.struct.FunctionWithParamOnly;
import com.wsq.library.struct.FunctionWithResultOnly;
import com.wsq.library.struct.FunctionsManage;
import com.wsq.library.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    private Fragment curFragment;
    private FragmentManager fragmentManager;
    private List<Fragment> mListFragment;

    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    public void initView() {
        mListFragment = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        ipresenter.showData();
    }

    @Override
    public void showData(List<String> data) {
        onEnter(new MainFragment(), MainFragment.TAG, false);
    }


    /**
     *
     * @param fragment
     * @param tag
     * @param isBack  是否支持返回
     */
    private void onEnter( Fragment fragment, String tag, boolean isBack){
        onEnter(fragment, tag, null, isBack);
    }

    /**
     *
     * @param fragment
     * @param tag
     * @param param 传递的参数
     * @param isBack  是否支持返回
     */
    private void onEnter(Fragment fragment, String tag, Bundle param, boolean isBack){
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();

        if (curFragment != null) fTransaction.hide(curFragment);

        if (!fragment.isAdded()) {
            if (param != null) fragment.setArguments(param);

            mListFragment.add(fragment);
            fTransaction.add(R.id.layout_content, fragment, tag);
            if (isBack)fTransaction.addToBackStack(tag);
            fTransaction.show(fragment).commit();
        } else {
            fTransaction.show(fragment).commit();
        }
        curFragment = fragment;
    }


    public void setFunctionsForFragment(String tag){

        FragmentManager fm = getSupportFragmentManager();
        final BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);

        FunctionsManage functionsManage = FunctionsManage.getInstance();


        functionsManage.addFunction(new FunctionWithParamOnly<Integer>(OneTabFragment.INTERFACE_WITHP) {
            @Override
            public void function(Integer data) {
                switch (data){
                    case 0:

                        break;
                    case 1://水印页面监听
                        onEnter(new WaterFragment(), WaterFragment.TAG, true);
                        break;
                    case 2:
                        onEnter(new IndexFragment(), IndexFragment.TAG, true);
                        break;
                    case 3:
                        onEnter(new CityFragment(), CityFragment.TAG, true);
                        break;
                    default:
                        ToastUtils.onToast("努力完善中...");
                        break;
                }
            }
        });
        functionsManage.addFunction(new FunctionWithParamOnly<Integer>(TwoTabFragment.INTERFACE_WITHP) {
            @Override
            public void function(Integer data) {
                switch (data){
                    case 0:
                        onEnter(new MediaFragment(), MediaFragment.TAG, true);
                        break;
                    case 1:
                        onEnter(new DataValidateFragment(), DataValidateFragment.TAG, true);
                        break;
                    case 2:
                        onEnter(new AnimatorFragment(), AnimatorFragment.TAG, true);
                        break;
                    case 3:
                        onEnter(new ReflectFragment(), ReflectFragment.TAG, true);
                        break;
                    case 4:
                        onEnter(new DesignPatternFragment(), DesignPatternFragment.TAG, true);
                        break;
                    default:
                        ToastUtils.onToast("努力完善中...");
                        break;
                }
            }
        });

        functionsManage.addFunction(new FunctionWithParamOnly<Integer>(ThreeTabFragment.INTERFACE_WITHP) {
            @Override
            public void function(Integer data) {
                switch (data){
                    case 0:
                            onEnter(new AmountFragment(), AmountFragment.TAG, true);
                        break;
                    case 1:
                            onEnter(new DialogFragment(), DialogFragment.TAG, true);
                        break;
                    case 2:
                        onEnter(new EditTextFragment(), EditTextFragment.TAG, true);
                        break;
                    case 3:
                        onEnter(new BannerFragment(), BannerFragment.TAG, true);
                        break;
                    case 4:
                        onEnter(new DbFragment(), DbFragment.TAG, true);
                        break;
                    case 5:
                        onEnter(new ImageFragment(), ImageFragment.TAG, true);
                        break;
                    case 6:
                        onEnter(new RefreshFragment(), RefreshFragment.TAG, true);
                        break;
                    case 7:
                        onEnter(new CustomControlFragment(), CustomControlFragment.TAG, true);
                        break;
                    case 8:
                        onEnter(new CanvasBitmapFragment(), CanvasBitmapFragment.TAG, true);
                        break;
                    default:
                        ToastUtils.onToast("努力完善中...");
                        break;
                }
            }
        });

        /**
         * 返回按钮的事件监听
         */
        functionsManage.addFunction(new FunctionNoParamNoResult(AmountFragment.INTERFACE_BACK) {
            @Override
            public void function() {
                onKeyBack();
            }
        });


        functionsManage.addFunction(new FunctionNoParamNoResult(CityFragment.INTERFACE_NPNR) {
            @Override
            public void function() {

                onEnter(new CitySearchFragment(), CitySearchFragment.TAG, true);
            }
        });



        /****
         * ******************************测试的接口****************************************************
         */
        functionsManage.addFunction(new FunctionNoParamNoResult(TabFragment.INTERFACE_NPNR) {
            @Override
            public void function() {

                ToastUtils.onToast("成功调用无参无返回值的接口");
            }
        });
        functionsManage.addFunction(new FunctionWithParamOnly<UserBean>(TabFragment.INTERFACE_WITHP) {
            @Override
            public void function(UserBean data) {
                ToastUtils.onToast(data.toString());
            }
        });

        functionsManage.addFunction(new FunctionWithResultOnly<String>(TabFragment.INTERFACE_WITHR) {
            @Override
            public String function() {
                return "测试只有返回值";
            }
        });

        functionsManage.addFunction(new FunctionWithParamAndResult<String, Integer>(TabFragment.INTERFACE_WITHPR) {
            @Override
            public String function(Integer data) {
                return "测试有参有返回值成功  "+data;
            }


        });
        fragment.setFunctionsManager(functionsManage);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                onKeyBack();
                break;
        }
        return true;
    }

    private void onKeyBack(){

        fragmentManager.popBackStack();
        if (mListFragment.size() > 1) {
            mListFragment.remove(mListFragment.size() - 1);
            curFragment = mListFragment.get(mListFragment.size()-1);
        }else{
            finish();
        }
    }


}
