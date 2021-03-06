package com.example.wsq.androidutils.fragment.main.custom;

import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.adapter.CityAdapter;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.DialogTools;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;
import com.wsq.library.views.alertdialog.CustomDefaultDialog;
import com.wsq.library.views.alertdialog.CustomViewDialog;
import com.wsq.library.views.alertdialog.OnDialogClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class DialogFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String TAG = DialogFragment.class.getName();
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
        tv_title.setText("AlertDiaog");

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 10),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdapter = new DefaultAdapter(getActivity(), mData, mListener);
        rv_RecyclerView.setAdapter(mAdapter);
        ipresenter.showDialogData();

    }

    @OnClick(R.id.ll_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }
    OnRecyclerViewItemClickListener mListener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {

            switch (position){
                case 0:
                    DialogTools.showDialog(getActivity(), "确定", "提示", "这个是在测试单个按钮", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();
                        }
                    });
                    break;
                case 1:
                    DialogTools.showDialog(getActivity(), "确定", "提示", "这个是在测试输入框的返回值", false, new OnDialogClickListener() {
                        @Override
                        public void onClick(CustomDefaultDialog dialog, String result, int requestCode) {
                            ToastUtils.onToast(result);
                            dialog.dismiss();
                        }
                    });
                    break;
                case 2:
                    DialogTools.showDialog(getActivity(), "确定", "取消", "提示", "这个是在测试两个按钮的显示", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.dismiss();
                        }
                    });
                    break;
                case 3:
                    DialogTools.showDialog(getActivity(), "确定", "取消", "提示", "这个是在测试两个按钮的返回", true, new OnDialogClickListener() {
                        @Override
                        public void onClick(CustomDefaultDialog dialog, String result, int requestCode) {

                            ToastUtils.onToast(result);
                            dialog.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                case 4:
                    DialogTools.showDialog(getActivity(), "确定", "提示", "这个是在测试修改标题颜色", "#FF0000", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                case 5:
                    DialogTools.showDialog(getActivity(), "确定", "提示", "这个是在测试修改内容颜色", "#FF0000","#FFFF00", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                case 6:
                    DialogTools.showDialog(getActivity(), "确定", "提示", "这个是在测试修改按钮颜色",
                            "#FF0000","#FFFF00","#ac54bb", "#FF00FF", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                case 7:
                    DialogTools.showDialog(getActivity(), "确定", "取消", "提示", "这个是在测试修改按钮背景颜色",
                            "#FF0000", "#FFFF00", "#FFFFFF", "#FFFFFF", "#FF0000", "#0000FF", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                    break;
                case 8:
                    CustomViewDialog.Builder builder = new CustomViewDialog.Builder(getActivity());
                    View v = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom_dialog_view, null, false);
                    builder.setView(v);
                    builder.setWidth(0.9f);
                    builder.setHeight(0.6f);
                    builder.setBack(false);
                    builder.create().show();
                    break;
                default:
                    onShowDialog();
                    break;
            }

        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {

        }
    };

    @Override
    public void showData(List<String> data) {

        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    private void onShowDialog(){

        CustomDefaultDialog.Builder builder = new CustomDefaultDialog.Builder(getActivity());
        builder.setMessage("努力完善中，请稍后");
//        builder.setShowMessage(false);
        builder.setTitle("提示");
//        builder.setIsShowInput(true);
        builder.setOkBtn("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelBtn("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
        builder.setOkBtnColor("#FF0000");
        builder.setTitleColor("#00FF00");
        builder.setMessageColor("#0000FF");
        builder.create().show();
    }
}
