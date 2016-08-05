package com.abc.app.airbnbcityapp;

import java.util.List;

/**
 * Created by hb2003 on 2016-08-04.
 */
public interface MemberService {
    public String regist(MemberBean mem);
    public void update(MemberBean mem);
    public void delete(MemberBean mem);
    public MemberBean findById(String id);
    public boolean login(MemberBean member);
    public void logout(MemberBean member);
    public int count();
    public List<MemberBean> list();
    public MemberBean show();
    public MemberBean getSession();
    public List<MemberBean> findBy(String keyword);
}
