package com.itwill.shoes.order;

import com.itwill.shoes.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderItem {
	private int oi_no;
	private int oi_qty;
	private Order order;
	private Product product;
	
	
	

}
