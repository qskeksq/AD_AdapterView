package com.nadan.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String getResult = getIntent().getStringExtra(CustomListActivity.DATA_KEY);
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(getResult);

        int getResId = getIntent().getExtras().getInt(CustomListActivity.DATA_RES_ID);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(getResId);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
