package com.nadan.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    public static final String DATA_KEY = "result";
    public static final String DATA_RES_ID = "resId";

    ListView listView;
    ArrayList<Data> datas;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        //1.
        listView = (ListView) findViewById(R.id.customListView);

        //2.
        datas = DataLoader.getDatas(this);

        //3.
        adapter = new CustomAdapter(datas, this);

        //4.
        listView.setAdapter(adapter);

        //5.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                String result = datas.get(position).title;
                int resId = datas.get(position).resId;
                intent.putExtra(DATA_KEY, result);
                intent.putExtra(DATA_RES_ID, resId);
                startActivity(intent);
            }
        });

    }
}
