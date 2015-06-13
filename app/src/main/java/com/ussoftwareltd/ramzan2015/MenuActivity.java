package com.ussoftwareltd.ramzan2015;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.ussoftwareltd.ramzan2015.alerams.AlarmActivity;
import com.ussoftwareltd.ramzan2015.allahnames.AllahName;
import com.ussoftwareltd.ramzan2015.compas.CompasActivity;
import com.ussoftwareltd.ramzan2015.sheridua.Sehri_Iftari_Dua;
import com.ussoftwareltd.ramzan2015.tosbih.TosbihActivity;

/**
 * Created by Bappy on 5/30/2015.
 */
public class MenuActivity extends ActionBarActivity {
    ImageView sehri_ifter_time;
    ImageView sehri_ifter_dua;
    ImageView ramadan_time;
    ImageView allah_name;
    ImageView islam_question;
    ImageView tosbih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity_layout);
        sehri_ifter_time=(ImageView)findViewById(R.id.sehri_ifter_time);
        sehri_ifter_dua=(ImageView)findViewById(R.id.sehri_ifter_dua);
        ramadan_time=(ImageView)findViewById(R.id.ramadan_time);
        allah_name=(ImageView)findViewById(R.id.allah_name);
        islam_question=(ImageView)findViewById(R.id.islam_question);
        tosbih=(ImageView)findViewById(R.id.tosbih);

        sehri_ifter_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, Sheri_Ifter_Times.class);
                startActivity(i);
            }
        });
        islam_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, CompasActivity.class);
                startActivity(i);
            }
        });

        tosbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, TosbihActivity.class);
                startActivity(i);
            }
        });
        ramadan_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, AlarmActivity.class);
                startActivity(i);
            }
        });
        sehri_ifter_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, Sehri_Iftari_Dua.class);
                startActivity(i);
            }
        });
        allah_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, AllahName.class);
                startActivity(i);
            }
        });


    }
}
