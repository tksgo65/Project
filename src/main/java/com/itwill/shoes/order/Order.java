package com.itwill.shoes.order;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.shoes.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor




public class Order {
	private int o_no;
	private String o_name;
	private Date o_date;
	private int o_price; 
	private String userid; //FK
	
	
	@Default
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();

}
