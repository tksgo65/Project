package com.itwill.shoes.product;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {
	private int p_no;
	private String p_name;
	private String p_type;
	private String P_brand;
	private int p_price;
	private String P_desc;
	private String P_image;
	
	
	

}
