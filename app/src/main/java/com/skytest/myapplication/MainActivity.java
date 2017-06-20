package com.skytest.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
       // try {
            int i = 1 / 0;

       //} catch (Exception e) {

       //    Toast.makeText(this, "修复了", Toast.LENGTH_SHORT).show();
       //    return;
       //}
        Toast.makeText(this, "还没修复", Toast.LENGTH_SHORT).show();

    }
}
