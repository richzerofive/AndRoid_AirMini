package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CityListActivity extends Activity {
    ListView lv_Citylist;
    CityService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        service = new CityServiceImpl(this.getApplicationContext());
        ArrayList<CityBean> list = service.list();
        lv_Citylist = (ListView) findViewById(R.id.lv_Citylist);
        lv_Citylist.setAdapter(new CityAdapter(this,list));
        lv_Citylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lv_Citylist.getItemAtPosition(position);
                CityBean City = (CityBean) o;
                Toast.makeText(CityListActivity.this,"선택한이름:"+City.getId(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CityListActivity.this,DetailActivity.class);
                intent.putExtra("address",City.getAddress());
                startActivity(intent);

            }
        });
        lv_Citylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v,
                                           int position, long id) {
                new AlertDialog.Builder(CityListActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                return true;
            }
        });
    }
    public ArrayList<CityBean> getList(){
        ArrayList<CityBean> list = new ArrayList<CityBean>();

        String[] names={
                "cupcake",
                "donut",
                "eclair",
                "froyo",
                "honeycomb",
                "icecream",
                "jellybean",
                "kitkat",
                "lollipop"
        };
        int i = 0;
        while (i<names.length) {
            CityBean City = new CityBean();
            City.setAddress(names[i]);
            City.setPrice("1000000");
            list.add(City);
            i++;
        }
        return list;
    }

}
