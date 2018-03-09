package com.example.wsq.androidutils.activity;


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
import com.example.wsq.androidutils.fragment.main.custom.CityFragment;
import com.example.wsq.androidutils.fragment.main.custom.CitySearchFragment;
import com.example.wsq.androidutils.fragment.main.custom.IndexFragment;
import com.example.wsq.androidutils.fragment.main.custom.WaterFragment;
import com.example.wsq.androidutils.fragment.main.tab.OneTabFragment;

import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.umeng.analytics.MobclickAgent;
import com.wsq.library.struct.FunctionNoParamNoResult;
import com.wsq.library.struct.FunctionWithParamAndResult;
import com.wsq.library.struct.FunctionWithParamOnly;
import com.wsq.library.struct.FunctionWithResultOnly;
import com.wsq.library.struct.FunctionsManage;
import com.wsq.library.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        MobclickAgent.onProfileSignIn("wsq");
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
    public void onEnter( Fragment fragment, String tag, boolean isBack){
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        List<Fragment> fragments = fragmentManager.getFragments();


        if (curFragment != null) fTransaction.hide(curFragment);

        if (!fragment.isAdded()) {
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
                fragmentManager.popBackStack();
                if (mListFragment.size() > 1) {
                    mListFragment.remove(mListFragment.size() - 1);
                    curFragment = mListFragment.get(mListFragment.size()-1);
                }else{
                    finish();
                }
                break;
        }
        return true;
    }


}
