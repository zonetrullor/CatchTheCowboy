package com.yavuz.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

    }
    public void easy(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
        startActivity(intent);


    }
    public void normal(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity5.class);
        startActivity(intent);


    }
    public void hard(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity6.class);
        startActivity(intent);

    }
    public void main(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);

    }



}