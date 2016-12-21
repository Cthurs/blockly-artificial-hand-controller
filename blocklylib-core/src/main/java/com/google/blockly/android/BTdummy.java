package com.google.blockly.android;

import android.content.Context;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

/**
 * Created by Cha on 2016-12-20.
 */

public class BTdummy {
    protected final Context mContext;
    int thumb;
    int index;
    int middle;
    int ring;
    int baby;
    public BTdummy(Context context){
        mContext = context;
        thumb = 0;
        index = 0;
        middle = 0;
        ring = 0;
        baby = 0;
    }
    public void dummy(String finger, String ford){
        Log.d("test:",finger+ford);
        switch (finger){
            case "  thumb":
                thumb = Integer.parseInt(ford);
//                Toast.makeText(mContext, "thumb : "+ford, Toast.LENGTH_LONG).show();
                break;
            case "  index":
                index = Integer.parseInt(ford);
//                Toast.makeText(mContext, "index : "+ford, Toast.LENGTH_LONG).show();
                break;
            case "  middle":
                middle = Integer.parseInt(ford);
//                Toast.makeText(mContext, "middle : "+ford, Toast.LENGTH_LONG).show();
                break;
            case "  ring":
                ring = Integer.parseInt(ford);
//                Toast.makeText(mContext, "ring : "+ford, Toast.LENGTH_LONG).show();
                break;
            case "  baby":
                baby = Integer.parseInt(ford);
//                Toast.makeText(mContext, "baby : "+ford, Toast.LENGTH_LONG).show();
                break;
        }
    }

    //TODO: 이 메소드를 통해 thumb/index/middle/ring/baby를 전달 하면 됨. Toast 대신 블루투스 전달 함수 넣기.
    public void send(){
        Toast.makeText(mContext, "블루투스를 통해 값을 전달합니다.\nthumb : "+thumb+" / index : "+index+" / middle : "+middle+" / ring : "+ring+" / baby : "+baby, Toast.LENGTH_LONG).show();
    }
}
