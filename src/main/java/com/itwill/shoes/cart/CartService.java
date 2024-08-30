package com.itwill.shoes.cart;

public class CartService {
	private CartDao cartDao;
	
	public CartService () throws Exception{
		cartDao=new CartDao();
		
	}
	public int addCart(Cart cart)throws Exception{
		if(cartDao.countByProductNo(cart.getUser().getUserId(), cart.getProduct().getP_no())>0) {
			
			return cartDao.updateByProductNo(cart);
		}else {
			return cartDao.insert(cart);
		}
	}

}
