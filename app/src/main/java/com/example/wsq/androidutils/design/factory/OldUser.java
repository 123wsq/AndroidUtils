package com.example.wsq.androidutils.design.factory;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class OldUser implements UserInfo{

    public static final int ID =1;
    @Override
    public String getName() {
        return "wsq";
    }

    @Override
    public String getSex() {
        return "男";
    }

    @Override
    public int getAge() {
        return 82;
    }
}
