package com.myfistapp.food_order_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
    private List<photo> mListPhoto;

    //Khai báo GridView
    GridView gridView;
    String[] ten={
            "Món 1","Món 2","Món 3","Món 4","Món 5","Món 6","Món 7","Món 8","Món 9","Món 10","Món 11","Món 12",
    };
    int[] hinh={
            R.drawable.menu_item1,R.drawable.menu_item2,
            R.drawable.menu_item3,R.drawable.menu_item4,
            R.drawable.menu_item5,R.drawable.menu_item1,
            R.drawable.menu_item1,R.drawable.menu_item2,
            R.drawable.menu_item3,R.drawable.menu_item4,
            R.drawable.menu_item5,R.drawable.menu_item1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        //Ánh xạ bottomNavigation
        bottomNavigationView = findViewById(R.id.navmenu);

        //Ánh xạ GridView
        mViewPager =findViewById(R.id.viewpage);
        mCircleIndicator=findViewById(R.id.circle_indicator);

        //Ánh xạ GridView
        gridView = findViewById(R.id.gridview);

        //Code ImageSlider
        mListPhoto = getmListPhoto();
        PhotoViewPagerAdapter adapter = new PhotoViewPagerAdapter(mListPhoto);
        mViewPager.setAdapter(adapter);

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
    private List<photo> getmListPhoto(){
        List<photo> list = new ArrayList<>();
        list.add(new photo((R.drawable.banner1)));
        list.add(new photo((R.drawable.banner2)));
        list.add(new photo((R.drawable.banner1)));

        return list;
    }
}