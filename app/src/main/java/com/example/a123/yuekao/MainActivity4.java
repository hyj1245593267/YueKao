package com.example.a123.yuekao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.a123.yuekao.Model.MyOmliteHelper;
import com.example.a123.yuekao.Model.Student;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity4 extends Activity {
    Dao<Student, ?> dao;
    @Bind(R.id.tname)
    EditText tname;
    @Bind(R.id.tprice)
    EditText tprice;
    @Bind(R.id.tcontent)
    EditText tcontent;
    @Bind(R.id.main4button)
    Button main4button;
    MyOmliteHelper helper = new MyOmliteHelper(this, "Student.db", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main4button)
    public void onViewClicked() {
        try {
            dao = helper.getDao(Student.class);
            String name=tname.getText().toString().trim();
            int price=Integer.parseInt(tprice.getText().toString().trim());
            String content=tcontent.getText().toString().trim();
            Student stu=new Student();
            stu.setName(name);
            stu.setPrice(price);
            stu.setContent(content);
            int i = dao.create(stu);
            if(i!=0){
                Intent in=new Intent(MainActivity4.this,MainActivity2.class);
                MainActivity4.this.startActivity(in);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
