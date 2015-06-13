package com.ussoftwareltd.ramzan2015.tosbih;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ussoftwareltd.ramzan2015.R;

/**
 * Created by Bappy on 6/3/2015.
 */
public class TosbihActivity extends ActionBarActivity {
    TextView tvCount;
    ImageButton btnMinus,btnTosbih,btnReload;
    int count=0;
    int sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tosbih_activity_layout);

        tvCount=(TextView)findViewById(R.id.tvCount);
        btnMinus=(ImageButton)findViewById(R.id.btnMinus);
        btnTosbih=(ImageButton)findViewById(R.id.btnTosbih);
        btnReload=(ImageButton)findViewById(R.id.btnReload);

        tvCount.setText(count+"");

        btnTosbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvCount.setText(count + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    count--;
                }
                tvCount.setText(count+"");
            }
        });
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                tvCount.setText(count+"");
            }
        });


    }
}
