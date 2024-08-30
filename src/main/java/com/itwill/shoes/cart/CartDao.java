package com.itwill.shoes.cart;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shoes.common.DataSource;
import com.itwill.shoes.product.Product;
import com.itwill.shoes.user.User;

public class CartDao {
	
	private DataSource dataSource;
	public CartDao() throws Exception{
		dataSource = new DataSource();
		
	}
	
	public int deleteByUserId(String sUserId) throws Exception{
		Connection con=null;
		PreparedStatement pstmt =null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
			
		}
		return deleteRowCount;
	}
	public List<Cart> findByUserId(String userid) throws Exception{
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				cartList.add(Cart.builder()
						.cart_no(rs.getInt("cart_no"))
						.cart_qty(rs.getInt("cart_qty"))
						.user(User.builder().userId(rs.getString("userid"))
						.build())
						.product(Product.builder()
								.p_no(rs.getInt("p_no"))
								.p_name(rs.getString("p_name"))
								.p_type(rs.getString("p_type"))
								.P_brand(rs.getString("p_brand"))
								.p_price(rs.getInt("p_price"))
								.P_image(rs.getString("p_image"))
								.build())
						.build());
			}
		}finally {
			if(con!=null) {
				dataSource.close(con);
			}
			
			return cartList;
			
		}
	}

	
	
	

}
