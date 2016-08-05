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

public class BookListActivity extends Activity{
    ListView lv_Booklist;
    CityService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        service = new CityServiceImpl(this.getApplicationContext());
        ArrayList<CityBean> list = service.list();
        lv_Booklist = (ListView) findViewById(R.id.lv_Booklist);
        lv_Booklist.setAdapter(new CityAdapter(this,list));
        lv_Booklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lv_Booklist.getItemAtPosition(position);
                CityBean City = (CityBean) o;
                Toast.makeText(BookListActivity.this,"선택한이름:"+City.getId(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(BookListActivity.this,DetailActivity.class);
                intent.putExtra("Address",City.getAddress());
                startActivity(intent);

            }
        });
        lv_Booklist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v,
                                           int position, long id) {
                new AlertDialog.Builder(BookListActivity.this)
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