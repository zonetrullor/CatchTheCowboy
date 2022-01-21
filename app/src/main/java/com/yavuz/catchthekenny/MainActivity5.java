package com.yavuz.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

// LEVEL 2

public class MainActivity5 extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    MediaPlayer kennyMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        timeText=(TextView) findViewById(R.id.timeText);
        scoreText = (TextView) findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2= findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageArray = new ImageView[]{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        hideImages();
        score=0;
        new CountDownTimer(30000 ,1000){

            @Override
            public void onTick(long millisUntilFinished){
                timeText.setText("Time : "+ millisUntilFinished/1000);
            }
            @Override
            public void onFinish(){
                timeText.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
                alert.setTitle("Restart");
                alert.setMessage("Are You sure to restart game ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity5.this, "Game Over!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity5.this,MainActivity3.class);
                        startActivity(intent);
                    }
                });
                alert .show();


            }

        }.start();
    }
    public void increaseScore (View view){

        score++;
        //score = score + 1;
        scoreText.setText("Score: "+score);
        if (score == 30) {
            timeText.setText("You Won");
            handler.removeCallbacks(runnable);
            for (ImageView image : imageArray) {
                image.setVisibility(View.INVISIBLE);
            }

            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
            alert.setTitle("Next Level !");
            alert.setMessage("Congratulations, you've earned the go to the next level !");
            alert.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                    startActivity(intent);
                }
            });
            alert.show();

            alert.setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                    startActivity(intent);
                }
            });
            alert.show();


        }

    }
    public void  hideImages(){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 500);



            }




        };
        handler.post(runnable);




    }




    public void soundOn(View view){
        if (kennyMusic==null){
            kennyMusic = MediaPlayer.create(MainActivity5.this , R.raw.song);

        }
        kennyMusic.start();
    }
    public void soundOff(View view){
        if(kennyMusic !=null){
            kennyMusic.pause();
        }
    }




}