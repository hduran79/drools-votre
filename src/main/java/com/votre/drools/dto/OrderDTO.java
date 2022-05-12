package com.votre.drools.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = -1737228979099865218L;
	private String type;
	private int discount;
	private String status;
	private String zone;
	private Boolean shipto;
	

}
