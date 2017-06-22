package com.skytest.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
         try {
          int i = 1 / 0;

         } catch (Exception e) {

             Toast.makeText(this, "修复了", Toast.LENGTH_SHORT).show();
             return;
         }
        //Toast.makeText(this, "还没修复", Toast.LENGTH_SHORT).show();
    }

    public void killself(View view) {
        // FIXME: 2017/6/21 只是做一个重启测试
         AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
         builder.setTitle("测试");
        builder.setMessage("是否重启app");
         builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
             }
         });
         builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                  //杀死当前进程并重新启动当前进程
                 // FIXME: 2017/6/21 注意MyService是有进程名称的详细见Manifest
                 startService(new Intent(MainActivity.this, MyService.class));
                 android.os.Process.killProcess(android.os.Process.myPid());//杀死当前包名的进程
             }
         });
         builder.show();
    }
}
