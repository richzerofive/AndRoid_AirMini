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

        SQLiteDatabase db2 = this.getWritableDatabase();
        db2.execSQL(sql2);

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

        SQLiteDatabase db3 = this.getWritableDatabase();
        db3.execSQL(sql3);

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

        SQLiteDatabase db4 = this.getWritableDatabase();
        db4.execSQL(sql4);

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
        String sql = "select * from "+TABLE_NAME+String.format("where id = '%s';",mBean.getId());

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

