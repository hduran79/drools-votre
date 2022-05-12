package com.votre.drools.business;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kie.api.runtime.KieSession;

import com.votre.drools.dto.InitValidateRuleDTO;
import com.votre.drools.dto.OrderDTO;

@ApplicationScoped
public class ProductBusiness {

	private KieSession kieSession;

	
	ProductBusiness() {
		/* for CDI*/
	}
	
	@Inject
	public ProductBusiness(KieSession kieSession) {		
		this.kieSession = kieSession;
	}

	public OrderDTO getProduct(String zone) {

		InitValidateRuleDTO init = InitValidateRuleDTO.builder().zone(zone).order(OrderDTO.builder().build()).build();
		
		kieSession.insert(init);
        kieSession.fireAllRules();
        
		return init.getOrder();
	}

}
