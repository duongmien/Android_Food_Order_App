package com.myfistapp.food_order_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myfistapp.food_order_app.Adapter.DiaChiAdapter;
import com.myfistapp.food_order_app.Class.DiaChiChiTiet;
import com.myfistapp.food_order_app.R;

import java.util.ArrayList;
import java.util.List;

public class DiaChi extends AppCompatActivity {

    private Spinner spnQuanHuyen, spnPhuongXa;
    private DiaChiAdapter quanhuyenAdapter, phuongxaAdapter;
    private TextView btn_xacnhan;
    private DiaChiAdapter quanhuyenAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi);

        btn_xacnhan = findViewById(R.id.btn_xacnhan);
        spnQuanHuyen = findViewById(R.id.spn_quanhuyen);
        spnPhuongXa = findViewById(R.id.spn_phuongxa);


        quanhuyenAdapter1 = new DiaChiAdapter(this,R.layout.holder_selected_diachi,getListQuanhuyen());
        phuongxaAdapter = new DiaChiAdapter(this,R.layout.holder_selected_diachi,getListPhuongxa());

        spnQuanHuyen.setAdapter(quanhuyenAdapter);
        spnPhuongXa.setAdapter(phuongxaAdapter);

        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spnQuanHuyen.getSelectedItem()==""){
                    Toast.makeText(DiaChi.this, "Vui long nhập Quận/Huyện", Toast.LENGTH_SHORT).show();
                }else if(spnPhuongXa.getSelectedItem()==""){
                    Toast.makeText(DiaChi.this, "Vui long nhập Phường/Xã", Toast.LENGTH_SHORT).show();
                }else{
                    String diachi = spnPhuongXa.getSelectedItem()+" "+spnQuanHuyen.getSelectedItem()+" Đà Nẵng";

                    Intent intent = new Intent(DiaChi.this, LienHe.class);
                    intent.putExtra("DiaChi", diachi);
                    startActivity(intent);
                }
            }
        });


    }
    private List<DiaChiChiTiet> getListQuanhuyen(){
        List<DiaChiChiTiet> list = new ArrayList<>();
        list.add(new DiaChiChiTiet("place1"));
        list.add(new DiaChiChiTiet("place2"));
        list.add(new DiaChiChiTiet("place3"));
        list.add(new DiaChiChiTiet("place4"));
        list.add(new DiaChiChiTiet("place5"));
        return list;
    }
    private List<DiaChiChiTiet> getListPhuongxa(){
        List<DiaChiChiTiet> list = new ArrayList<>();
        list.add(new DiaChiChiTiet("place1.1"));
        list.add(new DiaChiChiTiet("place1.2"));
        list.add(new DiaChiChiTiet("place1.3"));
        list.add(new DiaChiChiTiet("place1.4"));
        list.add(new DiaChiChiTiet("place1.5"));
        return list;
    }
}