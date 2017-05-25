package com.nadan.android.myapplication;

import android.content.Context;

import java.util.ArrayList;


public class DataLoader {

    public static ArrayList<Data> getDatas(Context context){
        ArrayList<Data> datas = new ArrayList<>();
        for(int i=0; i<5; i++){
            Data data = new Data();
            data.no = i+1;
            data.title = "데이터"+(i+1);

            data.setResId(i+1, context);

            datas.add(data);
        }
        return datas;
    }

}
