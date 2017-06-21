package com.skytest.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {
    public static String TAG = "AppApplication";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
         Log.d("AppApplication", "onBind() called with: intent = [" + intent + "]");
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart() called with: intent = [" + intent + "], startId = [" + startId + "]");
        SystemClock.sleep(1000);
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent1);
        Log.d(TAG, "开启");
        //这里可以自杀掉service
        System.exit(0);
    }
}
