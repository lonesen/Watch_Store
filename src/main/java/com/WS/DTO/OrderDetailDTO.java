package com.WS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailDTO {
    private String name;
    private Integer quantity;
    
    
	public OrderDetailDTO(String name, Integer quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
	
	
    
    
}

