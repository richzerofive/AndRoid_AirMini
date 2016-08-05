package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

public class GuideActivity extends Activity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        pager= (ViewPager)findViewById(R.id.pager);
        CustomAdapter adapter= new CustomAdapter(getLayoutInflater());

        pager.setAdapter(adapter);

    }


    public void mOnClick(View v){

        int position;

        switch( v.getId() ){
            case R.id.btn_previous:

                position=pager.getCurrentItem();
                pager.setCurrentItem(position-1,true);

                break;

            case R.id.btn_next:

                position=pager.getCurrentItem();
                pager.setCurrentItem(position+1,true);

                break;
        }

    }
}
