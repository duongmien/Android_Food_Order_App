package com.myfistapp.food_order_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.myfistapp.food_order_app.R;
import com.myfistapp.food_order_app.photo;

import java.util.List;

public class PhotoViewPagerAdapter extends PagerAdapter {

    public PhotoViewPagerAdapter(List<photo> mListPhoto) {
        this.mListPhoto = mListPhoto;
    }

    private List<photo> mListPhoto;


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgphoto = view.findViewById(R.id.img_photo);

        photo photo = mListPhoto.get(position);
        imgphoto.setImageResource(photo.getResourceId());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto!=null){
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
