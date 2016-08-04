package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity implements View.OnClickListener{
    Button bt_hosting,bt_list,bt_book,bt_book_list,bt_community,bt_guide,bt_log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt_hosting = (Button) findViewById(R.id.bt_hosting);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_book = (Button) findViewById(R.id.bt_book);
        bt_book_list = (Button) findViewById(R.id.bt_book_list);
        bt_community = (Button) findViewById(R.id.bt_community);
        bt_guide = (Button) findViewById(R.id.bt_guide);
        bt_log_out = (Button) findViewById(R.id.bt_log_out);

        bt_hosting.setOnClickListener(this);
        bt_list.setOnClickListener(this);
        bt_book.setOnClickListener(this);
        bt_book_list.setOnClickListener(this);
        bt_community.setOnClickListener(this);
        bt_guide.setOnClickListener(this);
        bt_log_out.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_hosting:
                startActivity(new Intent(this, HostingActivity.class));
                break;
            case R.id.bt_list:
                startActivity(new Intent(this, CityListActivity.class));;
                break;
            case R.id.bt_book :
                startActivity(new Intent(this,/*BookingActivity*/BookActivity.class));
                break;
            case R.id.bt_book_list :
                startActivity(new Intent(this,/*BookListActivity*/BookListActivity.class));
                break;
            case R.id.bt_community :
                startActivity(new Intent(this,/*CommunityActivity*/MainActivity.class));
                break;
            case R.id.bt_guide :
                startActivity(new Intent(this, GuideActivity.class));
                break;
            case R.id.bt_log_out :
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}