package com.example.wsq.androidutils.mvp.model.inter;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.wsq.library.bean.CityInfoBean;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public interface DefaultModelInter {

    void showData(Callback<List<String>> callback);

    void showTwoData(Callback<List<String>> callback);

    void showThreeData(Callback<List<String>> callback);

    void showDialogData(Callback<List<String>> callback);

    void showMediaData(Callback<List<String>> callback);

    void showBannerUrl(Callback<List<String>> callback);

    void showSqlite(Callback<List<String>> callback);

    void showRefreshData(Callback<List<String>> callback);

    void showValidateData(Callback<List<String>> callback);

    void showDesignPatternData(Callback<List<String>> callback);

    void showUtilsClass(Callback<List<String>> callback);

    void showAppManagerValidate(Callback<List<String>> callback);

    void onShowIndexBar(Callback<List<CityInfoBean>> callback);

    void onWaterFallData(Callback<List<Map<String, Object>>> callback);
}
