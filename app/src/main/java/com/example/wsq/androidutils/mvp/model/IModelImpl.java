package com.example.wsq.androidutils.mvp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/17.
 */

public class IModelImpl implements IModel{

    @Override
    public void loadData(OnDataLoadListener loadListener) {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("isFirst",true);
        list.add(map);

        loadListener.onComplete(list);
    }


    public void loadFragmentMainData(OnDataLoadListener loadListener){


    }
}
