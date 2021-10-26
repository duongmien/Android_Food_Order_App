package com.myfistapp.food_order_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.myfistapp.food_order_app.adapter.GridviewAdapter;
import com.myfistapp.food_order_app.adapter.PhotoViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class TrangChu extends AppCompatActivity {

    //Khai báo botomNavigation
    private BottomNavigationView bottomNavigationView;

    //Khai báo ImageSlide
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<Photo> mListPhoto;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem()==mListPhoto.size()-1){
                mViewPager.setCurrentItem(0);
            }else {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        }
    };
    //Khai báo GridView
    GridView gridView;
    String[] ten={
            "Món 1","Món 2","Món 3","Món 4","Món 5","Món 6","Món 7","Món 8"
    };
    int[] hinh={
            R.drawable.favorite_food_1,R.drawable.favorite_food_2,
            R.drawable.favorite_food_3,R.drawable.favorite_food_4,
            R.drawable.favorite_food_5,R.drawable.favorite_food_6,
            R.drawable.favorite_food_7,R.drawable.favorite_food_8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trang_chu);

        //Ánh xạ bottomNavigation
        bottomNavigationView = findViewById(R.id.navmenu);

        //Ánh xạ imageslide
        mViewPager =findViewById(R.id.viewpage);
        mCircleIndicator=findViewById(R.id.circle_indicator);

        //Ánh xạ GridView
        gridView = findViewById(R.id.gridview);

        //Code ImageSlider
        mListPhoto = getmListPhoto();
        PhotoViewPagerAdapter adapter = new PhotoViewPagerAdapter(mListPhoto);
        mViewPager.setAdapter(adapter);
        mViewPager.setPageTransformer(true, new DepthPageTransformer ());
        mViewPager.setTranslationX(-1 * mViewPager.getWidth() * mViewPager.getCurrentItem());
        mCircleIndicator.setViewPager(mViewPager);

        handler.postDelayed(runnable,3000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Code GridView
        GridviewAdapter gridviewAdapter=new GridviewAdapter(this,ten,hinh);
        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TrangChu.this, ten[i], Toast.LENGTH_SHORT).show();
            }
        });

        //Code bottomNavigation
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Toast.makeText(TrangChu.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_favorite:
                        Toast.makeText(TrangChu.this, "Favorite Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_cart:
                        Toast.makeText(TrangChu.this, "Cart Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_profile:
                        Toast.makeText(TrangChu.this, "Profile Page", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });

    }

    //Thêm ảnh Slider
    private List<Photo> getmListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo((R.drawable.banner1)));
        list.add(new Photo((R.drawable.banner2)));
        list.add(new Photo((R.drawable.banner1)));

        return list;
    }
    //slide tranform
    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }



}