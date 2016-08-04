package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity implements View.OnClickListener{
    Button bt_hosting,bt_img,bt_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt_hosting = (Button) findViewById(R.id.bt_hosting);
        bt_img = (Button) findViewById(R.id.bt_img);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_hosting.setOnClickListener(this);
        bt_img.setOnClickListener(this);
        bt_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_hosting:
                startActivity(new Intent(this, HostingActivity.class));
                break;
            case R.id.bt_img:
                startActivity(new Intent(this, ImageActivity.class));;
                break;
            case R.id.bt_list:
                startActivity(new Intent(this, CityListActivity.class));;
                break;
        }
    }
}