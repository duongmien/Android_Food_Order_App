package com.myfistapp.food_order_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.myfistapp.food_order_app.R;

public class ThongTinCaNhan extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);

        }
    private void bottomNavigation() {
        bottomNavigationView = findViewById(R.id.navmenu);
        bottomNavigationView.setSelectedItemId(R.id.nav_cart);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(ThongTinCaNhan.this, TrangChu.class));
                        break;

                    case R.id.nav_favorite:
                        Toast.makeText(ThongTinCaNhan.this, "Favorite Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_cart:
                        Toast.makeText(ThongTinCaNhan.this, "Cart Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_profile:
                        Toast.makeText(ThongTinCaNhan.this, "Profile Page", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });

    }
}