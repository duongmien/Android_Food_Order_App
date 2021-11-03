package com.myfistapp.food_order_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.myfistapp.food_order_app.Adapter.GioHangAdapter;
import com.myfistapp.food_order_app.Helper.ManagementCart;
import com.myfistapp.food_order_app.Interface.ChangeNumberItemsListener;
import com.myfistapp.food_order_app.R;

import java.text.DecimalFormat;

public class GioHang extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView tongtien, tongsanpham,emptyTxt,btndathang,pttt;
    private RelativeLayout rediachi,redanhsach,rethanhtoan;
    private BottomNavigationView bottomNavigationView;
    private ImageView btnpttt,btndiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        managementCart = new ManagementCart(this);

        initView();

        Intent intent = getIntent();
        String Pttt = intent.getStringExtra("PTTT");
        pttt.setText(Pttt);

        initList();
        calculateCard();
        bottomNavigation();

        btndiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GioHang.this, LienHe.class));
            }
        });

        btnpttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GioHang.this, ThanhToan.class));
            }
        });
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pttt.getText()==""){
                    Toast.makeText(GioHang.this, "Hãy chọn phương thức thanh toán", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GioHang.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static String currencyFormat(Double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((amount));
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
        bottomNavigationView.setSelectedItemId(R.id.nav_cart);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(GioHang.this, TrangChu.class));
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
        tongtien.setText(currencyFormat(managementCart.getTotalFee())+ " VNĐ" );
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
        pttt= findViewById(R.id.txt_pttt);
        btnpttt= findViewById(R.id.img_arrow);
        btndiachi= findViewById(R.id.btn_diachi);
    }
}