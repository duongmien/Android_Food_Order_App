package com.myfistapp.food_order_app.Activity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.myfistapp.food_order_app.R;

public class Introduction extends AppCompatActivity {
    ImageView logo;
    LottieAnimationView lottieAnimationView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);
        logo = findViewById(R.id.logo_app);
        lottieAnimationView=findViewById(R.id.lottie_intro);
        textView=findViewById(R.id.textView);
        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000);
        textView.animate().setDuration(1000).setStartDelay(4000);
    }
}