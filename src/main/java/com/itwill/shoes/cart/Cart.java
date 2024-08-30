package com.itwill.shoes.cart;

import com.itwill.shoes.product.Product;
import com.itwill.shoes.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cart {
	private int cart_no;
	private int cart_qty;
	private User user;
	private Product product;
	
	

}
