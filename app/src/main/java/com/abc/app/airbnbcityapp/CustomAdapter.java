package com.abc.app.airbnbcityapp;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by hb2003 on 2016-08-04.
 */
public class CustomAdapter extends PagerAdapter{
    LayoutInflater inflater;

    public CustomAdapter(LayoutInflater inflater) {
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 10;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=null;
        view= inflater.inflate(R.layout.viewpager_guideview, null);
        ImageView img= (ImageView)view.findViewById(R.id.img_viewpager_guideimage);

        img.setImageResource(R.drawable.guide_01+position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;
    }

}

