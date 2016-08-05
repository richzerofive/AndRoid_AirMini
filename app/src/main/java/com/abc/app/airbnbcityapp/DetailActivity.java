package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity implements View.OnClickListener{
    CityService service;
    TextView tv_addr,tv_price,tv_form,tv_rooms,tv_toil,tv_bed,tv_facil;
    Button bt_view, bt_list;
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
        tv_form = (TextView) findViewById(R.id.tv_form);
        tv_form.setText(member.getHouseType());
        tv_rooms = (TextView) findViewById(R.id.tv_rooms);
        tv_rooms.setText(String.valueOf(member.getRoom()));
        tv_toil = (TextView) findViewById(R.id.tv_toil);
        tv_toil.setText(String.valueOf(member.getToilet()));
        tv_bed = (TextView) findViewById(R.id.tv_bed);
        tv_bed.setText(String.valueOf(member.getBed()));
        tv_facil = (TextView) findViewById(R.id.tv_facil);
        tv_facil.setText(member.getFacilities());
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_list.setOnClickListener(this);
        bt_view = (Button) findViewById(R.id.bt_view);
        bt_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_view:
                startActivity(new Intent(this,ImageActivity.class));
                break;
            case R.id.bt_list:
                startActivity(new Intent(this,CityListActivity.class));
                break;
        }
    }
}

