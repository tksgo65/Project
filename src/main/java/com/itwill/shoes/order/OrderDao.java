package com.itwill.shoes.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shoes.common.DataSource;
import com.itwill.shoes.user.User;

public class OrderDao {
	private DataSource dataSource;
	public OrderDao() throws Exception{
		dataSource=new DataSource();
	}
	/*
	 * 주문전체리스트 (특정사용자)
	 */
	public List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception{
		List<Order> orderList=new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
	try {
		con=dataSource.getConnection();
		
		pstmt1=con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
		pstmt1.setString(1, sUserId);
		rs1 = pstmt1.executeQuery();
		while(rs1.next()) {
			Order order=Order.builder()
					.o_no(rs1.getInt("o_no"))
					.o_name(rs1.getString("o_name"))
					.o_date(rs1.getDate("o_date"))
					.o_price(rs1.getInt("o_price"))
				    .user(User.builder()
				    		.userId(rs1.getString("sUserId"))
				    		.build())
				    .build();
			orderList.add(order);
		}
		
		pstmt2=con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
		for(int i=0; i<orderList.size(); i++) {
			Order order = orderList.get(i);
			
			pstmt2.setInt(1, order.getO_no());
			rs2=pstmt2.executeQuery();
		}
	}
		
		
	
	}
		
	}
	


