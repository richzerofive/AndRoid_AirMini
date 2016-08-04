package com.abc.app.airbnbcityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends Activity implements View.OnClickListener{
    EditText et_id,et_pw,et_name,et_gender,et_email,et_birth,et_phone,et_address,et_intro,et_sns,et_profile_img;
    Button bt_join,bt_reset;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id= (EditText) findViewById(R.id.et_id);
        et_pw= (EditText) findViewById(R.id.et_pw);
        et_name= (EditText) findViewById(R.id.et_name);
        et_gender= (EditText) findViewById(R.id.et_gender);
        et_sns= (EditText) findViewById(R.id.et_sns);
        et_phone= (EditText) findViewById(R.id.et_phone);
        et_email= (EditText) findViewById(R.id.et_email);
        et_birth= (EditText) findViewById(R.id.et_birth);
        et_address= (EditText) findViewById(R.id.et_address);
        et_intro= (EditText) findViewById(R.id.et_intro);
        et_profile_img= (EditText) findViewById(R.id.et_profile_img);
        bt_join= (Button) findViewById(R.id.bt_join);
        bt_reset= (Button) findViewById(R.id.bt_reset);
        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join:
                Toast.makeText(JoinActivity.this,
                        "id:"+et_id.getText().toString()
                                +"pw:"+et_pw.getText().toString()
                                +"name"+et_name.getText().toString()
                                +"ssn:"+et_sns.getText().toString()
                                +"phone:"+et_phone.getText().toString()
                                +"email:"+et_email.getText().toString()
                                +"gender:"+et_gender.getText().toString()
                                +"birth:"+et_birth.getText().toString()
                                +"address:"+et_address.getText().toString()
                                +"intro:"+et_intro.getText().toString()
                                +"profile_img:"+et_profile_img.getText().toString()
                        , Toast.LENGTH_LONG).show();
                MemberBean member = new MemberBean();
                member.setId(et_id.getText().toString());
                member.setPw(et_pw.getText().toString());
                member.setName(et_name.getText().toString());
                member.setPhone(et_phone.getText().toString());
                member.setEmail(et_email.getText().toString());
                member.setGender(et_gender.getText().toString());
                member.setBirth(et_birth.getText().toString());
                member.setAddress(et_address.getText().toString());
                member.setIntro(et_intro.getText().toString());
                member.setSns(et_sns.getText().toString());
                member.setProfile_img(et_profile_img.getText().toString());

                service.regist(member);

                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.bt_reset:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
