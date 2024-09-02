package com.itwill.shoes.cart;

public class CartSQL {
	public static final String CART_INSERT = "insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,?,?,?)";
	public static final String CART_SELECT_BY_USERID = "select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid=?";
}
