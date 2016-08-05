package com.abc.app.airbnbcityapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hb2003 on 2016-08-03.
 */
public class CityDAO extends SQLiteOpenHelper {
    private MemberService service2;
    public static final String TABLE_NAME = "city_member";
    public static final String address = "address";
    public static final String explain = "explain";
    public static final String price = "price";
    public static final String facilities = "facilities";
    public static final String house_type = "house_type";
    public static final String photo = "photo";
    public static final String room = "room";
    public static final String toilet = "toilet";
    public static final String bed = "bed";
    public static final String count = "count";
    public static final String id = "id";
    public static final String checkIn = "checkIn";
    public static final String checkOut = "checkOut";

    public CityDAO(Context context) {

        super(context, "hanbit", null, 1);
        Log.d("DB 생성 체크", "======================여기가지 집입");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("");
        this.onCreate(db);
    }

    public int insert(CityBean bean) {
        int result = 0;
        Log.d("======insert 진입=====", "123");
        String sql = "insert into " + TABLE_NAME
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s) ", address, explain, price, facilities, house_type, photo, room, toilet, bed, count)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%d','%d','%d','%d' );"
                , bean.getAddress()
                , bean.getExplain()
                , bean.getPrice()
                , bean.getFacilities()
                , bean.getHouseType()
                , "default"
                , bean.getRoom()
                , bean.getToilet()
                , bean.getBed()
                , bean.getCount());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

        return result;
    }

    public CityBean findByAddr(String addr) {
        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s ", address, explain, price, facilities, house_type, photo, room, toilet, bed, count)
                + String.format("from " + TABLE_NAME + " where address = '%s' ;", addr);
        CityBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        Log.d("DAO FIND_BY_ADDR", "ADDR 조회 성공 !!");
        Log.d("???????????????","?????????????!!!!");
        Log.d("???뭐야!!",addr);
        while(cursor.moveToNext()) {
            temp = new CityBean();
            temp.setAddress(cursor.getString(cursor.getColumnIndex(address)));
            temp.setExplain(cursor.getString(1));
            temp.setPrice(cursor.getString(2));
            temp.setFacilities(cursor.getString(3));
            temp.setHouseType(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setRoom(Integer.parseInt(cursor.getString(6)));
            temp.setToilet(Integer.parseInt(cursor.getString(7)));
            temp.setBed(Integer.parseInt(cursor.getString(8)));
            temp.setCount(Integer.parseInt(cursor.getString(9)));
        }

        return temp;
    }

    public int book(CityBean bean) {
        Log.d("===bookDAO진입===","123");
        int result = 0;
        String sql = "update " + TABLE_NAME
                +String.format(" set address = '%s', explain = '%s', price = '%s', facilities = '%s', house_type = '%s', photo = '%s'" +
                ", room = '%d', toilet = '%d', bed = '%d', checkIn = '%s', checkOut = '%s', count = '%d' where address = '%s';"
                , bean.getAddress()
                , bean.getExplain()
                , bean.getPrice()
                , bean.getFacilities()
                , bean.getHouseType()
                , "default"
                , bean.getRoom()
                , bean.getToilet()
                , bean.getBed()
                , bean.getCheckIn()
                , bean.getCheckOut()
                , bean.getCount()
                , bean.getAddress()
        );
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }


    public ArrayList<CityBean> list() {
        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s ", address, explain, price, facilities, house_type, room, toilet, bed, count)
                + " from " + TABLE_NAME + ";";
        ArrayList<CityBean> list = new ArrayList<CityBean>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            Log.d("DAO LIST", "목록조회 성공 !!");
            cursor.moveToFirst();
        }
        do {
            CityBean temp = new CityBean();
            temp.setAddress(cursor.getString(0));
            temp.setExplain(cursor.getString(1));
            temp.setPrice(cursor.getString(2));
            temp.setFacilities(cursor.getString(3));
            temp.setHouseType(cursor.getString(4));
            temp.setRoom(Integer.parseInt(cursor.getString(5)));
            temp.setToilet(Integer.parseInt(cursor.getString(6)));
            temp.setBed(Integer.parseInt(cursor.getString(7)));
            temp.setCount(Integer.parseInt(cursor.getString(8)));
            list.add(temp);
        } while (cursor.moveToNext());
        return list;
    }

}
