package com.itwill.shoes.user;

public class UserSQL {
	public static final String USER_INSERT="insert into userinfo(userid,password,name,address,phonenumber) values(?,?,?,?,?)";
    public static final String USER_UPDATE= "update userinfo set password=?,name=?,address=?,phonenumber=? where userid=?";
    public static final String USER_REMOVE="delect from userinfo where userid=?";
    public static final String USER_SELECT_BY_ID="select userid,password,name,address,phonenumber from userinfo where userid=?";
    public static final String USER_SELECT_BY_ID_COUNT= "select count(*) as cnt from userinfo where userid=?";
	

}
