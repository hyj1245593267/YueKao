package com.example.a123.yuekao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a123.yuekao.ApapterModel.Main2listAdapter;
import com.example.a123.yuekao.Model.MyOmliteHelper;
import com.example.a123.yuekao.Model.Student;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity2 extends Activity {
    Dao<Student, ?> dao;
    @Bind(R.id.main2list)
    ListView main2list;
    @Bind(R.id.main2button)
    Button main2button;
    List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        getDao();
        main2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("AAAAAAA","AAAAAAAAAA");
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                MainActivity2.this.startActivity(intent);
            }
        });
        main2list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                i.putExtra("name",students.get(position).getName());
                i.putExtra("price",students.get(position).getPrice()+"");
                i.putExtra("content",students.get(position).getContent());
                MainActivity2.this.startActivity(i);

            }
        });
    }

    private void getDao() {
        MyOmliteHelper helper = new MyOmliteHelper(this, "Student.db", null, 1);
        try {
            Log.e("AAAAAAA","AAAAVBBBBBBBBBAAAAAA");
            dao = helper.getDao(Student.class);
            students = dao.queryForAll();
            Main2listAdapter adapter = new Main2listAdapter(students, MainActivity2.this);
            main2list.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


