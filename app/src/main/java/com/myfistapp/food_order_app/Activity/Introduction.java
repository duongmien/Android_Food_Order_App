package com.myfistapp.food_order_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.myfistapp.food_order_app.Adapter.ViewPageAdapter;
import com.myfistapp.food_order_app.R;

public class Introduction extends AppCompatActivity {
    ViewPager mSliderViewPager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn, skipbtn;
    TextView[] dots;

    ViewPageAdapter viewPageAdapter= new ViewPageAdapter(this);

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                 mSliderViewPager.setCurrentItem(mSliderViewPager.getCurrentItem() + 1, true);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);
//        logo = findViewById(R.id.logo_app);
////        lottieAnimationView=findViewById(R.id.lottie_intro);
//        textView=findViewById(R.id.textView);
////        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000);
//        textView.animate().setDuration(1000).setStartDelay(4000);
        backbtn=findViewById(R.id.backbtn);
        nextbtn=findViewById(R.id.nextbtn);
        skipbtn=findViewById(R.id.skipbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0)>0){
                    mSliderViewPager.setCurrentItem(getItem(-1),true);
                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0)<3){
                    mSliderViewPager.setCurrentItem(getItem(1),true);
                }
                else {
                    Intent i = new Intent (Introduction.this, Splash.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Introduction.this, Splash.class);
                startActivity(i);
                finish();
            }
        });

        mSliderViewPager=(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout=(LinearLayout) findViewById(R.id.indicator_layout);

        mSliderViewPager.setAdapter(viewPageAdapter);
        setUpindicator(0);
        mSliderViewPager.addOnPageChangeListener(viewlistener);
        handler.postDelayed(runnable,3000);

    }
    public void setUpindicator(int position){
        dots = new TextView[4];
        mDotLayout.removeAllViews();
        for(int i=0; i<dots.length; i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.xam));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.black));
    }
    ViewPager.OnPageChangeListener viewlistener =new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);
            if(position>0){
                backbtn.setVisibility(View.VISIBLE);
            }
            else {
                backbtn.setVisibility(View.INVISIBLE);
            }
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable,3000);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private int getItem(int i){
        return mSliderViewPager.getCurrentItem()+i;
    }
}