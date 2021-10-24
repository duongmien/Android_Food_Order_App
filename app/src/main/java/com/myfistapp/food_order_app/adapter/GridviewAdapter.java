package com.myfistapp.food_order_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myfistapp.food_order_app.R;

public class GridviewAdapter extends BaseAdapter {
    private Context context;
    private String[] tenlogo;
    private int[] hinhlogo;

    public GridviewAdapter(Context context, String[] tenlogo, int[] hinhlogo) {
        this.context = context;
        this.tenlogo = tenlogo;
        this.hinhlogo = hinhlogo;
    }

    @Override
    public int getCount() {
        return tenlogo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.gridview_row,null);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);

        textView.setText(tenlogo[i]);
        imageView.setImageResource(hinhlogo[i]);

        return view;
    }
}
