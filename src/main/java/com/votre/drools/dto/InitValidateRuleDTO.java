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
public class InitValidateRuleDTO  implements Serializable {

	private static final long serialVersionUID = 9146083802954277255L;
	private String zone;
	private OrderDTO order;

}
