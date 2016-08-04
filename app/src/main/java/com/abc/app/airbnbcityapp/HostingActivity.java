package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HostingActivity extends Activity implements View.OnClickListener{
    EditText et_form,et_rooms,et_count,et_toil,et_facil,et_exp,et_addr,et_price,et_bed;
    Button bt_join,bt_reset;
    CityService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosting);

        service = (CityService) new CityServiceImpl(this.getApplicationContext());
        et_form = (EditText) findViewById(R.id.et_form);
        et_rooms = (EditText) findViewById(R.id.et_rooms);
        et_count = (EditText) findViewById(R.id.et_count);
        et_toil = (EditText) findViewById(R.id.et_toil);
        et_facil = (EditText) findViewById(R.id.et_facil);
        et_exp = (EditText) findViewById(R.id.et_exp);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_price = (EditText) findViewById(R.id.et_price);
        et_bed= (EditText) findViewById(R.id.et_bed);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_reset = (Button) findViewById(R.id.bt_reset);
        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join:
                Toast.makeText(HostingActivity.this,"집유형"+et_form.getText().toString()+"방갯수"+et_rooms.getText().toString()+"인원수"+et_count.getText().toString()+"화장실갯수"+et_toil.getText().toString()+"설비:"+et_facil.getText().toString()+"설명"+et_exp.getText().toString(),Toast.LENGTH_LONG).show();
                CityBean member = new CityBean();
                member.setHouseType(et_form.getText().toString());
                member.setRoom(Integer.parseInt(et_rooms.getText().toString()));
                member.setCount(Integer.parseInt(et_count.getText().toString()));
                member.setToilet(Integer.parseInt(et_toil.getText().toString()));
                member.setFacilities(et_facil.getText().toString());
                member.setExplain(et_exp.getText().toString());
                member.setPhoto("default.jpg");
                member.setAddress(et_addr.getText().toString());
                member.setPrice(et_price.getText().toString());
                member.setBed(Integer.parseInt(et_bed.getText().toString()));
                service.regist(member);
                startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.bt_reset:
                startActivity(new Intent(this,HomeActivity.class));
                break;
        }
    }
}