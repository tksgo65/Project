package com.itwill.shoes.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.shoes.cart.Cart;
import com.itwill.shoes.cart.CartDao;
import com.itwill.shoes.product.ProductDao;
import com.itwill.shoes.user.User;



public class OrderService {
	
		private OrderDao orderDao;
		private CartDao cartDao;
		private ProductDao productDao;
		
		public OrderService()  throws Exception{
			orderDao=new OrderDao();
			cartDao=new CartDao();
			productDao=new ProductDao();
		}
		/*
		 * Cart에서주문
		 */
		public int create(String sUserId) throws Exception{
			
			int o_tot_price=0;
			int oi_tot_count=0;
			String o_desc="";
			List<OrderItem> orderItems=new ArrayList<OrderItem>();
			
			List<Cart> cartList= cartDao.findByUserId(sUserId);
			for(Cart cart:cartList) {
				OrderItem orderItem=OrderItem.builder()
									.oi_qty(cart.getCart_qty())
									.product(cart.getProduct())
									.build();
				orderItems.add(orderItem);
				o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
				oi_tot_count+=orderItem.getOi_qty();
			}
			
			o_desc=orderItems.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+"개";
			
			Order newOrder=Order.builder()
					        .o_name(o_desc)
							.orderItems(orderItems)
							.o_price(o_tot_price)
							.user(User.builder().userId(sUserId).build())
							.build();
			orderDao.insert(newOrder);
			cartDao.deleteByUserId(sUserId);
			return 0;
			
		}
		
		
	}
	
	


