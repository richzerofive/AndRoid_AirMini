package com.abc.app.airbnbcityapp;

import android.content.Context;

import java.util.List;

/**
 * Created by hb2003 on 2016-08-04.
 */
public class MemberServiceImpl implements MemberService{
    MemberDAO dao ;
    MemberBean session;
    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }
    @Override
    public String regist(MemberBean mem) {
        String msg = "";
        MemberBean temp = this.findById(mem.getId());
        if (temp == null) {
            System.out.println(mem.getId()+"가 존재하지 않음,가입 가능한 ID");
            int result = dao.regist(mem);
            if (result==0) {
                msg = "success";

            } else {
                msg = "fail";
            }
        } else {
            System.out.println(mem.getId()+"가 존재함,가입 불가능한 ID");
            msg = "fail";
        }

        return msg;
    }

    public MemberBean getSession() {
        return session;
    }

    @Override
    public void update(MemberBean mem) {
        int result = dao.update(mem);
        if (result == 1) {
            System.out.println("서비스 수정결과 성공");
        }else{
            System.out.println("서비스 수정결과 실패");
        }
    }



    @Override
    public void delete(MemberBean mem) {

    }

    @Override
    public MemberBean findById(String id) {
        return null;
    }

    @Override
    public boolean login(MemberBean member) {
            if (dao.login(member)) {
            session = dao.findById(member);
        }
        return true;
    }


    @Override
    public void logout(MemberBean member) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<MemberBean> list() {
        return null;
    }

    @Override
    public MemberBean show() {
        return null;
    }

    @Override
    public List<MemberBean> findBy(String keyword) {
        return null;
    }
}
