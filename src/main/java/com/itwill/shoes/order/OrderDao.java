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
			dataSource = new DataSource();
		}
		
		/*
		 * 주문전체삭제( ON DELECT CASCADE )
		 */
		public int delectByUserId(String sUserId) throws Exception{
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
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			}finally {
				if(con != null)
					con.close();
					
			}
			return rowCount;
			
			/*
			 * 주문1건삭제 (on delect cascade)
			 */
		}
		public int deleteByOrderNo(int o_no) throws Exception{
			Connection con =null;
			PreparedStatement pstmt =null;
			int rowCount = 0;
			
			try {
				con = dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(OrderSQL.ORDER_DELECT_BY_O_NO);
				pstmt.setInt(1, o_no);
				rowCount = pstmt.executeUpdate();
				con.commit();
				
			}catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			} finally {
				if(con != null)
					con.close();
			}
			return rowCount;
		}
		/*
		 * 주문생성
		 */
		public int insert(Order order) throws Exception{
			Connection con = null;
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt2 = null;
			try {
				con = dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
				pstmt1.setString(1, order.getO_name());
				pstmt1.setInt(2, order.getO_price());
				pstmt1.setString(3, order.getUserid());
				pstmt1.executeUpdate();
				
				pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
				for (OrderItem orderItem : order.getOrderItems()) {
					pstmt2.setInt(1, orderItem.getOi_qty());
					pstmt2.setInt(2, orderItem.getProduct().getP_no());
					pstmt2.executeUpdate();
				}
				con.commit();
				
			}catch(Exception e) {
				e.printStackTrace();
				con.rollback();
				throw e;
			
			}finally {
				if (con != null)
					con.close();
			}
			return 0;
			
		}



}

