package com.example.lenovo.mybmob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.save);
        button2 = (Button) findViewById(R.id.gx);
        button3 = (Button) findViewById(R.id.sc);

        Bmob.initialize(this, "6c448aed0c46b430d5f15a075a76109f");
        final Person person = new Person();
        person.setAddress("重庆");
        person.setName("lucky");
        person.setName("小花");
        person.setAddress("北京海淀");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                person.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, "创建数据成功" + objectId, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”

                person.setAddress("北京朝阳");
                person.update("b4c191be0f", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, "\"更新成功:\"+person.getUpdatedAt()", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "\"更新失败：\" + e.getMessage()", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setObjectId("ea2ccc4381");
                person.delete(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, "\"删除成功:\"+p2.getUpdatedAt()", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "\"删除失败：\" + e.getMessage()", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}