package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.design.factory.OldUser;
import com.example.wsq.androidutils.design.factory.UserFactory;
import com.example.wsq.androidutils.design.factory.UserInfo;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.orhanobut.logger.Logger;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class DesignPatternFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String TAG = DesignPatternFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.rv_RecyclerView)
    RecyclerView rv_RecyclerView;
    @BindView(R.id.tv_title)
    TextView tv_title;

    private DefaultAdapter mAdapter;
    private List<String> mData;


    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_title_list;
    }

    @Override
    protected void initView() {
        mData = new ArrayList<>();
        tv_title.setText("设计模式");

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 10),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdapter = new DefaultAdapter(getActivity(), mData, mListener);
        rv_RecyclerView.setAdapter(mAdapter);
        ipresenter.showDesignPatternData();

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
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    OnRecyclerViewItemClickListener mListener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {

            switch (position){
                case 2:
                    UserFactory factory = new UserFactory();
                    UserInfo info =factory.createUser(OldUser.class);
                    ToastUtils.onToast("name="+info.getName()+", sex = "+info.getSex()+", age = "+info.getAge());
                    break;
                case 12:
                    //注册观察者(这个方法名看起来有点怪，还不如写成regisiterSubscriber(..)或者干脆addSubscriber(..))
                    //注册后就会开始调用call()中的观察者执行的方法 onNext() onCompleted()等
//                    observable.subscribe(subscriber);
                    Observable.just(1,2,3,4,5,6,7,8,9,10)
                            .timeout(1000, TimeUnit.MILLISECONDS)
                            .filter(new Func1<Integer, Boolean>() {
                                @Override
                                public Boolean call(Integer integer) {
                                    return integer>5;
                                }
                            }).subscribe(new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {
                            System.out.println("Sequence complete.");
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.err.println("Error: " + e.getMessage());
                        }

                        @Override
                        public void onNext(Integer integer) {
                            System.out.println("Next: " + integer);
                        }
                    });
                    break;
            }
        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {

        }
    };

    /**
     * 创建一个被观察者(发布者)
     */
    Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
        @Override
        public void call(Subscriber<? super Integer> o) {

            o.onNext(101);
            o.onNext(102);
            o.onNext(103);
            o.onCompleted();
        }
    });

    /**
     * 创建一个观察者
     */
    Subscriber<Integer> subscriber = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted.. ");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "subscriber onError.. " + e.getMessage());
        }

        @Override
        public void onNext(Integer integer) {
            Log.d(TAG, "onNext.. integer:" + integer);
        }
    };
}

