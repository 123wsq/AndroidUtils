package com.example.wsq.androidutils.design.factory;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class UserFactory {

    public UserInfo createUser(int id){

        UserInfo info = null;
        switch (id){
            case 1:
                info = new OldUser();
                break;
        }
        return info;
    }


    public UserInfo createUser(Class<? extends UserInfo> classes){

        UserInfo info = null;

        try {
            info = classes.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return info;
    }
}
