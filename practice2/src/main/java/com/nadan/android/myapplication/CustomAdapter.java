package com.nadan.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-05-24.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<Data> datas;
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(ArrayList<Data> datas, Context context){
        this.datas = datas;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txt_no, txt_title;

        Holder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_list, null);
            holder = new Holder();
            //주소값을 물어서 찾아오는 일은 딱 10-11개만 하고 다음부터는 홀더에 넣어준 태그를 가져다 쓴다.
            holder.no = (TextView) convertView.findViewById(R.id.txt_img_no);
            holder.title = (TextView) convertView.findViewById(R.id.txt_img_title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            //컨버트뷰에 태그를 붙임으로써 컨버트뷰가 재사용되서 돌아올 때 또 주소를 묻지 않고 태그만 얻어올 수 있다.
            //findViewById가 리소스를 상대적으로 많이 사용하는 것으로 볼 때 많이 절약된다.
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        //어댑터에서 데이터를 넣은 컨버트뷰를 리스트에 보내 주는 것이다.
        Data data = datas.get(position);
        holder.no.setText(data.no+"");
        holder.title.setText(data.title);
        holder.imageView.setImageResource(data.resId);

        //어댑터는 컨버트뷰를 만들고, 데이터를 넣어주고 리스트뷰에 보내주는 역할을 하는구나!!
        return convertView;
    }
}
