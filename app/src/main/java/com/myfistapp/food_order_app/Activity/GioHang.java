package com.myfistapp.food_order_app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.myfistapp.food_order_app.Adapter.GioHangAdapter;
import com.myfistapp.food_order_app.Interface.ChangeNumberItemsListener;
import com.myfistapp.food_order_app.ManagementCart;
import com.myfistapp.food_order_app.R;

public class GioHang extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView tongtien, tongsanpham,emptyTxt,btndathang;
    private RelativeLayout rediachi,redanhsach,rethanhtoan;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        managementCart = new ManagementCart(this);


        initView();
        initList();
        calculateCard();
        bottomNavigation();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new GioHangAdapter(managementCart.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            rediachi.setVisibility(View.GONE);
            redanhsach.setVisibility(View.GONE);
            rethanhtoan.setVisibility(View.GONE);
            btndathang.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            rediachi.setVisibility(View.VISIBLE);
            redanhsach.setVisibility(View.VISIBLE);
            rethanhtoan.setVisibility(View.VISIBLE);
            btndathang.setVisibility(View.VISIBLE);
        }
    }

    private void bottomNavigation() {
        bottomNavigationView = findViewById(R.id.navmenu);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(GioHang.this, MainActivity.class));
                        break;

                    case R.id.nav_favorite:
                        Toast.makeText(GioHang.this, "Favorite Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_cart:
                        Toast.makeText(GioHang.this, "Cart Page", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_profile:
                        Toast.makeText(GioHang.this, "Profile Page", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });
    }

    private void calculateCard() {

        tongsanpham.setText("Tổng "+managementCart.getTotalItems()+" sản phẩm" );
        tongtien.setText(managementCart.getTotalFee()+"đ");
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recycleview_danhsach);
        tongtien = findViewById(R.id.txt_tongtien);
        tongsanpham = findViewById(R.id.txt_tongsanpham);
        emptyTxt = findViewById(R.id.emptyTxt);
        rediachi = findViewById(R.id.re_diachi);
        redanhsach= findViewById(R.id.re_danhsach);
        rethanhtoan= findViewById(R.id.re_thanhtoan);
        btndathang= findViewById(R.id.btn_dathang);

    }
}