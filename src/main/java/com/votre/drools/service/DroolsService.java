package com.votre.drools.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.votre.drools.business.ProductBusiness;
import com.votre.drools.dto.OrderDTO;

@Path("drool")
@Produces(MediaType.APPLICATION_JSON)
public class DroolsService implements Serializable {

	private static final long serialVersionUID = -3715306175245844822L;

	@Inject
	private ProductBusiness business;

	@POST
	@Path("sample/{status}")
	public OrderDTO save(@PathParam("status") String status) {
		return business.getProduct(status);
	}

}
