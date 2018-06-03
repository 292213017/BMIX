package com.example.yd.bmix;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yd.bmix.HistoryActivity;
import com.example.yd.bmix.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView TextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText) findViewById(R.id.edit_text1);
        editText2=(EditText) findViewById(R.id.edit_text2);
        TextView = (TextView) findViewById(R.id.textV);
        imageView=(ImageView) findViewById(R.id.image_view);
        Button button1=(Button) findViewById(R.id.button_1);
        String[] arr={};
        final int i=15;
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           String inputText1=editText1.getText().toString();
                                           String inputText2=editText2.getText().toString();
                                           float H = Float.parseFloat(inputText1)/100;
                                           float W = Float.parseFloat(inputText2);
                                           float BMI=W/(H*H);
                                           String B= String.valueOf(BMI);
                                           String Q="过轻";
                                           if (BMI<18.5){
                                               Q="过轻";
                                               imageView.setImageResource(R.drawable.mig_6);
                                           }
                                           else if (BMI>18.5&&BMI<24.99){
                                               Q="标准";
                                               imageView.setImageResource(R.drawable.mig_2);
                                           }
                                           else if (BMI>25&&BMI<28){
                                               Q="过重";
                                               imageView.setImageResource(R.drawable.mig_3);
                                           }
                                           else if (BMI>28&&BMI<32){
                                               Q="肥胖";
                                               imageView.setImageResource(R.drawable.mig_5);
                                           }
                                           else if (BMI>32){
                                               Q="非常肥胖";
                                               imageView.setImageResource(R.drawable.mig_4);
                                           }
                                           String p="你的IBM值为："+B+"  属于  "+Q;
                                           TextView.setText(p);
                                           SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
                                           Date curDate =  new Date(System.currentTimeMillis());
                                           String   str   =   formatter.format(curDate);
                                           Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                                           String data=B+str+inputText2;
                                           intent.putExtra("data1",data);
                /*intent.putExtra("extra_data1",B);
                intent.putExtra("extra_data2",str);
                intent.putExtra("extra_data3",inputText2);*/
                /*Bundle bundle = new Bundle();
                bundle.putString("data1",B);
                bundle.putString("data2",str);
                bundle.putString("data3",inputText2);
                intent.putExtra("data", bundle);*/
                                           //arr[i]=B+str+inputText2;
                                           //String k=String.valueOf(i);
                                           //intent.putExtra("data1",k)
                                           //intent.putExtra("data1",arr[i]);
                                           //i=i+1;
                                           startActivity(intent);
                                       }
                                   }
        );
    }


}