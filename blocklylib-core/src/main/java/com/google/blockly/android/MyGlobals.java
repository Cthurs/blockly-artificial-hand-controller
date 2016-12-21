package com.google.blockly.android;

import java.util.ArrayList;

/**
 * Created by Cha on 2016-12-10.
 */

public class MyGlobals {
    private ArrayList<String> codes = new ArrayList<String>();
    public ArrayList<String> getData()
    {
        return codes;
    }
    public void setData(String codes)
    {
        this.codes.add(codes);
    }
    private static MyGlobals instance = null;

    public static synchronized MyGlobals getInstance(){
        if(null == instance){
            instance = new MyGlobals();
        }
        return instance;
    }
}
