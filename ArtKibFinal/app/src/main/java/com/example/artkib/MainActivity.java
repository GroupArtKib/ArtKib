package com.example.artkib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int SplashScreen = 2500;
    ImageView image;
    Animation top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        image=findViewById(R.id.ImageLogo);

        top= AnimationUtils.loadAnimation(this, R.anim.top);

        image.setAnimation(top);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, secondpage.class);
                startActivity(intent);
                finish();
            }
        },SplashScreen);

    }
}