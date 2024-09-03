package com.itwill.shoes.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shoes.common.DataSource;
import com.itwill.shoes.product.Product;
import com.itwill.shoes.user.User;


public class OrderDao {
		private DataSource dataSource;
		
		public OrderDao() throws Exception{
			dataSource = new DataSource();
		}
		/*
		 * 주문전체리스트(특정사용자)
		 */
		public List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception{
			List<Order> orderList=new ArrayList<Order>();
			
			Connection con=null;
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt2 = null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			try {
				con=dataSource.getConnection();
				
				pstmt1=con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
				pstmt1.setString(1, sUserId);
				rs1 = pstmt1.executeQuery();
				while(rs1.next()) {
					Order order = Order.builder()
							.o_no(rs1.getInt("o_no"))
							.o_name(rs1.getString("o_name"))
							.o_date(rs1.getDate("o_date"))
							.o_price(rs1.getInt("o_price"))
							.user(User.builder()
									.userId(rs1.getString("userid"))
									.build())
							.build();
					orderList.add(order);
									
				}
				
				pstmt2=con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
				for(int i=0; i<orderList.size(); i++) {
					Order order= orderList.get(i);
					
					pstmt2.setInt(1, order.getO_no());
					rs2=pstmt2.executeQuery();
					
					Order orderWithOrderItem=null;
					if(rs2.next()) {
						orderWithOrderItem=Order.builder()
								.o_no(rs2.getInt("o_no"))
								.o_name(rs2.getString("o_name"))
								.o_date(rs2.getDate("o_date"))
								.o_price(rs2.getInt("o_price"))
								.user(User.builder().userId(rs2.getString("userid")).build())
								.build();
						do {
							orderWithOrderItem.getOrderItems()
							.add(OrderItem.builder()
									.oi_no(rs2.getInt("oi_no"))
									.oi_qty(rs2.getInt("oi_qty"))
									.order(Order.builder().o_no(rs2.getInt("o_no")).build())
									.product( Product.builder()
											.p_no(rs2.getInt("p_no"))
											.p_name(rs2.getString("p_name"))
											.p_type(rs2.getString("p_type"))
											.p_brand(rs2.getString("p_brand"))
											.p_price(rs2.getInt("p_price"))
											.p_desc(rs2.getString("p_desc"))
											.p_image(rs2.getString("p_image"))
											.build())
											.build());
						}while(rs2.next());
						
					}
					orderList.set(i, orderWithOrderItem);
				}
			}finally {
				if(con!=null)
					dataSource.close(con);
			}
			return orderList;
		
}
		/*
		 * 주문전체삭제(ON DELETE CASCADE)
		 */
		public int deleteByUserId(String sUserId) throws Exception{
			Connection con = null;
			PreparedStatement pstmt = null;
			int rowCount = 0;
			try {
				con = dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
				pstmt.setString(1, sUserId);
				rowCount = pstmt.executeUpdate();
				con.commit();
			}catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw e;
				
			}finally {
				if(con != null)
					con.close();
			}
			return rowCount;
		}
		public int deleteByOrderNo(int o_no) throws Exception {

			Connection con = null;
			PreparedStatement pstmt = null;
			int rowCount = 0;
			try {
				con = dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
				pstmt.setInt(1, o_no);
				rowCount = pstmt.executeUpdate();
				con.commit();
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			} finally {
				if (con != null)
					con.close();
			}
			return rowCount;
		}
		/*
		 * CART 에서 주문생성
		 */
		
		public int insert(Order order) throws Exception{
			Connection con=null;
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;
			try {
				con=dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt1=con.prepareStatement(OrderSQL.ORDER_INSERT);
				pstmt1.setString(1,order.getO_name());
				pstmt1.setInt(2,order.getO_price());
				pstmt1.setString(3,order.getUser().getUserId());
				pstmt1.executeUpdate();
				
				for(OrderItem orderItem : order.getOrderItems()) {
					pstmt2=con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
					pstmt2.setInt(1, orderItem.getOi_qty());
					pstmt2.setInt(2, orderItem.getProduct().getP_no());
					pstmt2.executeUpdate();
				}
				con.commit();
			}catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			}finally {
				if(con!=null)
					dataSource.close(con);
			}
			return 0;
		}
			
		
		

}

