package com.ussoftwareltd.ramzan2015.allahnames;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ussoftwareltd.ramzan2015.MainActivity;
import com.ussoftwareltd.ramzan2015.R;

/**
 * Created by Bappy on 6/4/2015.
 */
public class AllahName extends ActionBarActivity {

    ImageView imgOne,imgTwo,imgThree,imgFour,imgFive,imgSix,imgSeven,imgEight;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allah_names_layout);
        imgOne=(ImageView)findViewById(R.id.imgOne);
        imgTwo=(ImageView)findViewById(R.id.imgTwo);
        imgThree=(ImageView)findViewById(R.id.imgThree);
        imgFour=(ImageView)findViewById(R.id.imgFour);
        imgFive=(ImageView)findViewById(R.id.imgFive);
        imgSix=(ImageView)findViewById(R.id.imgSix);
        imgSeven=(ImageView)findViewById(R.id.imgSeven);
        imgEight=(ImageView)findViewById(R.id.imgEight);

        imgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mediaPlayer=MediaPlayer.create(AllahName.this, R.raw.allah_names_one);
                mediaPlayer.start();
            }
        });
        imgTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mediaPlayer.pause();
            }
        });
        imgThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(AllahName.this, R.raw.allah_names_two);
                mediaPlayer.start();
            }
        });
        imgFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        imgFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(AllahName.this, R.raw.allah_names_three);
                mediaPlayer.start();
            }
        });
        imgSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        imgSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(AllahName.this, R.raw.allah_names_four);
                mediaPlayer.start();
            }
        });
        imgEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

    }


}
