package com.example.a123.yuekao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
//当前时间 10:30 我叫霍玉洁 考试科目:android高级 B 专业移动互联
public class MainActivity extends Activity {

    @Bind(R.id.maintext)
    TextView maintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animion);
        maintext.setAnimation(animation);
        animation.setDuration(2000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        MainActivity.this.startActivity(intent);
                    }
                }.start();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}














