package com.abc.app.airbnbcityapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hb2003 on 2016-08-04.
 */
public class MemberDAO extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "member2";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String EMAIL = "email";
    public static final String BIRTH = "birth";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    public static final String INTRO = "intro";
    public static final String SNS = "sns";
    public static final String PROFILE_IMG = "profile_img";
    public static final String TABLE_NAME2 = "city_member";
    public static final String address2 = "address";
    public static final String explain2 = "explain";
    public static final String price2 = "price";
    public static final String facilities2 = "facilities";
    public static final String house_type2 = "house_type";
    public static final String photo2 = "photo";
    public static final String room2 = "room";
    public static final String toilet2 = "toilet";
    public static final String bed2 = "bed";
    public static final String count2 = "count";
    public static final String id2 = "id";
    public static final String checkIn2 = "checkIn";
    public static final String checkOut2 = "checkOut";

    public MemberDAO(Context context) {
        super(context, "hanbit", null, 1);
        Log.d("DB 생성 체크", "======================여기가지 집입");
        this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB 테이블  생성 체크2", "======================여기가지 집입");
        String sql = "create table if not exists "
                + TABLE_NAME
                + "("
                + ID + " text primary key,"
                + PW + " text,"
                + NAME + " text,"
                + GENDER + " text,"
                + EMAIL + " text,"
                + BIRTH + " text,"
                + PHONE + " text,"
                + ADDRESS + " text,"
                + INTRO + " text,"
                + SNS + " text,"
                + PROFILE_IMG + " text);";
        db.execSQL(sql);
        Log.d("DB 테이블  생성 체크3", "================실행======여기가지 집입");

        String sql2 = "insert into " + TABLE_NAME
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s) "
                , ID, PW, NAME, GENDER, EMAIL, BIRTH, PHONE, ADDRESS, INTRO, SNS, PROFILE_IMG)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                , "park"
                , "1"
                , "jaekwan"
                , "male"
                , "pakjkwan@gmail.com"
                , "780705"
                , "01090753070"
                , "suwon seoul"
                , "hi"
                , "kakao talk"
                , "secret"
        );


        db.execSQL(sql2);

        String sql3 = "insert into " + TABLE_NAME
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s) "
                , ID, PW, NAME, GENDER, EMAIL, BIRTH, PHONE, ADDRESS, INTRO, SNS, PROFILE_IMG)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                , "hong"
                , "1"
                , "gildong"
                , "male"
                , "gildong@gmail.com"
                , "780705"
                , "01095403080"
                , "suwon seoul"
                , "hi"
                , "kakao talk"
                , "secret"
        );


        db.execSQL(sql3);

        String sql4 = "insert into " + TABLE_NAME
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s) "
                , ID, PW, NAME, GENDER, EMAIL, BIRTH, PHONE, ADDRESS, INTRO, SNS, PROFILE_IMG)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                , "hongsam"
                , "1"
                , "fire"
                , "unisex"
                , "hongsam@gmail.com"
                , "700705"
                , "01000000000"
                , "one"
                , "hi"
                , "kakao talk"
                , "secret"
        );


        db.execSQL(sql4);
        Log.d("===onCreate진입====","123");


        String sql5 = "create table if not exists "
                + TABLE_NAME2
                + " ( "
                + address2 + " text primary key, "
                + explain2 + " text, "
                + price2 + " text, "
                + facilities2 + " text, "
                + house_type2 + " text, "
                + photo2 + " text, "
                + room2 + " integer, "
                + toilet2 + " integer, "
                + bed2 + " integer, "
                + count2 + " integer, "
                + id2 + " text, "
                + checkIn2 + " text, "
                + checkOut2 + " text );";


        db.execSQL(sql5);
        Log.d("DB 생성 table 체크", "======================여기가지 집입");

        sql2 = "insert into " + TABLE_NAME2
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s) ", address2, explain2, price2, facilities2, house_type2, photo2, room2, toilet2, bed2, count2)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s' );"
                , "seoul sinchon hanbit class2"
                , "class"
                , "$10"
                , "computer"
                , "class"
                , "default"
                , "1"
                , "1"
                , "3"
                , "15");

        db.execSQL(sql2);

        sql3 = "insert into " + TABLE_NAME2
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s) ", address2, explain2, price2, facilities2, house_type2, photo2, room2, toilet2, bed2, count2)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s' );"
                , "3 Pyrmont St, Pyrmont NSW 2009 AUS"
                , "share house"
                , "$210"
                , "strong vecuum"
                , "detached"
                , "no more"
                , "4"
                , "1"
                , "2"
                , "8");

        db.execSQL(sql3);

        sql4 = "insert into " + TABLE_NAME2
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s) ", address2, explain2, price2, facilities2, house_type2, photo2, room2, toilet2, bed2, count2)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s' );"
                , "424-458 Hoxton Park Rd Liverpool  NSW 2009 AUS"
                , "hotel"
                , "$1000"
                , "gym pool bar etc"
                , "hotel"
                , "default"
                , "100"
                , "100"
                , "300"
                , "400");

        db.execSQL(sql4);

        sql5 = "insert into " + TABLE_NAME2
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s) ", address2, explain2, price2, facilities2, house_type2, photo2, room2, toilet2, bed2, count2)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s' );"
                , "1600 Pennsylvania Ave NW, Washington, DC 20500"
                , "obama house"
                , "free"
                , "security guard"
                , "white house"
                , "secret"
                , "10"
                , "10"
                , "10"
                , "20");
        db.execSQL(sql5);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "drop table if exist" + TABLE_NAME;
    }

    public int regist(MemberBean mBean) {

        int result = 0;
        String sql = "insert into " + TABLE_NAME
                + String.format("( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s) "
                , ID, PW, NAME, GENDER, EMAIL, BIRTH, PHONE, ADDRESS, INTRO, SNS, PROFILE_IMG)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                , mBean.getId()
                , mBean.getPw()
                , mBean.getName()
                , mBean.getGender()
                , mBean.getEmail()
                , mBean.getBirth()
                , mBean.getPhone()
                , mBean.getAddress()
                , mBean.getIntro()
                , mBean.getSns()
                , mBean.getProfile_img()
        );

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }
    public MemberBean findById(MemberBean mBean) {
        MemberBean temp=null;
        String sql = "select * from "+TABLE_NAME+String.format(" where id = '%s';",mBean.getId());
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        return temp;
    }

    public boolean login(MemberBean mBean) {
        boolean loginCheck= false;
        String sql="select "+PW+" from "+TABLE_NAME
                +String.format(" where id ='%s';",mBean.getId());
        SQLiteDatabase db=this.getReadableDatabase();
        String pw="";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            pw=cursor.getString(0);
        }
        if (pw.equals("")){
            Log.d("DAO 로그인 결과=","일치하는 비번이 없음");
            loginCheck=false;
        }else {
            Log.d("DAO id :",mBean.getId());
            Log.d("DAO pw :",mBean.getPw());
            loginCheck=(pw.equals(mBean.getPw()))?true:false;

        }

        System.out.println("LOGIN_OK ?"+loginCheck);
        return loginCheck;
    }

    public int update(MemberBean mBean){

        int result=0;
        String sql = "update "
                +TABLE_NAME
                +String.format("set pw = '%s' , email = '%s', phone = '%s', address = '%s', intro = '%s' where id = '%s';"
                ,mBean.getPw()
                ,mBean.getEmail()
                ,mBean.getPhone()
                ,mBean.getAddress()
                ,mBean.getIntro()
                ,mBean.getId()
        );
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }


    public void delete(MemberBean mbean) {
        String sql = "delete from "
                +TABLE_NAME
                +String.format("where id=%s and pw = %s;"
                ,mbean.getId()
                ,mbean.getPw()
        );
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(sql);

    }
}

