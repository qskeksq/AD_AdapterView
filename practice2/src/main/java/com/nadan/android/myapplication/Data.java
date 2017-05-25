package com.nadan.android.myapplication;

import android.content.Context;

/**
 * Created by Administrator on 2017-05-24.
 */

//데이터에는 값이 들어간다.
public class Data {

    public int no; //넘버값
    public String title; //제목
    public String image;
    public int resId; // 이미지 아이디

    public void setResId(int position, Context context){

        resId = context.getResources().getIdentifier("android"+position, "mipmap", context.getPackageName());

    }

}
