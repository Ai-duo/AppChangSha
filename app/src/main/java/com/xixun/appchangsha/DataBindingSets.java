package com.xixun.appchangsha;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;


public  class DataBindingSets {


    @BindingAdapter("setTextColor")
    public static void setTextColor(TextView view, Integer index){
        if (index==null)return;
        if(index==0){
            view.setTextColor(Color.WHITE);
        }else if(index==1){
            view.setTextColor(Color.YELLOW);
        }else if(index==2){
            view.setTextColor(Color.argb(255,255,255,0));
        }
    }

    @BindingAdapter("setTemp")
    public static void setTemp(TempView view, String text){
        if (TextUtils.isEmpty(text))return;
        text = text.replace("℃","");
        if(text.equals("--"))text = "0";
        view.setMinc(Float.parseFloat("15"));
    }
    @BindingAdapter("setSd")
    public static void setTemp(ShiDuView view, String text){
        if (TextUtils.isEmpty(text))return;
        text = text.replace("℃","");
        if(text.equals("--"))text = "0";
        view.setMinc(Float.parseFloat("15"));
    }

}
