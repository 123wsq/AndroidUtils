package com.example.wsq.androidutils.mvp.model;

import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/24.
 */

public class FragmentModelImpl implements FragmentModel{
    @Override
    public void loadData(FragmentModel.OnDataLoadListener loadListener) {


        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map  = new HashMap<>();
        map.put(DefaultAdapter.KEY_DATA, "RececlerView");
        list.add(map);
        Map<String, Object> map1  = new HashMap<>();
        map1.put(DefaultAdapter.KEY_DATA, "图片水印");
        list.add(map1);
        Map<String, Object> map2  = new HashMap<>();
        map2.put(DefaultAdapter.KEY_DATA, "index");
        list.add(map2);

        Map<String, Object> map3  = new HashMap<>();
        map3.put(DefaultAdapter.KEY_DATA, "城市");
        list.add(map3);

        loadListener.onComplete(list);
    }
}
