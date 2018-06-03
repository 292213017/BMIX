package com.example.yd.bmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    private TextView TextView2;
    private TextView TextView3;
    private String data;
    private String[] datah={"商品1","商品2","商品3","商品4"};
    private TextView TextView;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TextView = (TextView) findViewById(R.id.text);
        //TextView2 = (TextView) findViewById(R.id.textV2);
        //TextView3 = (TextView) findViewById(R.id.textV3);
        //TextView4 = (TextView) findViewById(R.id.textV4);
        Intent intent = getIntent();
        /*String data1=intent.getStringExtra("extra_data1");
        String data2=intent.getStringExtra("extra_data2");
        String data3=intent.getStringExtra("extra_data3");*/
        /*Bundle bundle=intent.getBundleExtra("data");
        String data1=bundle.getString("data1");
        String data2=bundle.getString("data2");
        String data3=bundle.getString("data3");*/
        data=intent.getStringExtra("data1");
        if (i<=3) {
            datah[i] = data;
            i = i + 1;
        }
        else {
            i=3;
            for(int j=0;j<3;j++)
            {
                datah[j]=datah[j+1];
            }
            datah[i]=data;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                HistoryActivity.this,android.R.layout.simple_list_item_1,datah);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
/*        TextView.setText(data);*/
    }
/*    @Override
    protected void onDestroy(){
        super.onDestroy();
        String inputText
    }*/
}
