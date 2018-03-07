package com.wsq.library.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.Logger;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.utils.AppManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class DBManager {
    private  Context mContext;
    private  String DB_NAME = "address.sql";
    public DBManager(Context context){
        this.mContext = context;
    }

    /**
     *把assets目录下的db文件复制到dbpath下
     */
    public SQLiteDatabase DBManager() {
        String dbPath = "/data/data/" + AppManager.getAppPackageName()
                + "/databases/" + DB_NAME;
        if (!new File(dbPath).exists()) {
            try {
                FileOutputStream out = new FileOutputStream(dbPath);
                InputStream in = mContext.getAssets().open("db/address.sql");
                byte[] buffer = new byte[1024];
                int readBytes = 0;
                while ((readBytes = in.read(buffer)) != -1)
                    out.write(buffer, 0, readBytes);
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SQLiteDatabase.openOrCreateDatabase(dbPath, null);
    }


    /**
     * 获取所有的城市列表
     * @return
     */
    public List<CityInfoBean> getAllCityList(SQLiteDatabase db){
        List<CityInfoBean> list = new ArrayList<>();

        Cursor c = db.query("address", null, null, null, null, null, null, null);
        Logger.d("查询数据个数： "+c.getCount());
        return  list;
    }
}
