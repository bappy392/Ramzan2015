package com.ussoftwareltd.ramzan2015;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Bappy on 5/29/2015.
 */
public class Home extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.home_layout);

        MyThread t=new MyThread();
        t.start();

    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                sleep(1000);
                Intent i=new Intent(Home.this, MenuActivity.class);
                startActivity(i);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
