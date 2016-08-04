package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {
    CityService service;
    TextView tv_addr,tv_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        service = (CityService) new CityServiceImpl(getApplicationContext());
        Intent intent = getIntent();
        String addr =intent.getExtras().getString("address");
        CityBean member = service.findByAddr(addr);
        tv_addr= (TextView) findViewById(R.id.tv_addr);
        tv_addr.setText(member.getAddress());
        tv_price= (TextView) findViewById(R.id.tv_price);
        tv_price.setText(member.getPrice());
    }

}
