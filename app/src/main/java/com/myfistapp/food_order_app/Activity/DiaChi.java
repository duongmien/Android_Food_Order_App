package com.myfistapp.food_order_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myfistapp.food_order_app.R;

public class DiaChi extends AppCompatActivity {

    TextView btn_diachi,btn_hoanthanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi);

        initView();

        btn_hoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiaChi.this, GioHang.class));
            }
        });

    }

    private void initView() {
        btn_diachi = findViewById(R.id.txt_diachi);
        btn_hoanthanh = findViewById(R.id.btn_hoanthanh);
    }
    
}