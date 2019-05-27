package com.sir.app.paging;

/**
 * Created by zhuyinan on 2018/8/6.
 * Contact by 445181052@qq.com
 */
public class Student {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
