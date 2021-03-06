package com.example.wsq.androidutils.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by wsq on 2018/1/23.
 */

public class UserBean extends DataSupport{

    private int id;

    private String name;

    private int age;

    private String sex;

    public UserBean() {
        super();
    }

    /**
     *
     * @param id
     * @param name
     * @param age
     * @param sex
     */
    public UserBean(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "[id = "+id+
                ", name = "+name+"" +
                ", age = "+age+"" +
                ", sex = "+sex+"]";
    }
}
