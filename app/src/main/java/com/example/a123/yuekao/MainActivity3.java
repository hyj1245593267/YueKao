package com.example.a123.yuekao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a123.yuekao.Model.Student;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity3 extends Activity {

    @Bind(R.id.xname)
    TextView xname;
    @Bind(R.id.xprice)
    TextView xprice;
    @Bind(R.id.xcontent)
    TextView xcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String content = i.getStringExtra("content");
        int price = Integer.parseInt(i.getStringExtra("price"));
        xname.setText(name);
        xcontent.setText(content);
        xprice.setText(price+"");

    }
}
