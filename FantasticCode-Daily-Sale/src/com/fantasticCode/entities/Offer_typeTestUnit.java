package com.fantasticCode.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.When;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasticCode.repositories.Offer_type_Repository;
import com.fantasticCode.service.Offer_type_Service;

class Offer_typeTestUnit {
	
	@Autowired
	private Offer_type_Repository offer_type_repository;
	
	private Offer_type_Service offerService;
	
	Offer_type test;
	
	@Before
	public void setUp(){
		test = new Offer_type(1, "comida");
	}
	
	@Test
	public void saveOfferType() {
		//given
		test = offer_type_repository.save(test);
		//assertThat(offer_type_repository.findOne(test.getType())).isEqualTo((test));
	}

	@Test
	public void findAllOffer() {
		
		
		List<Offer_type> resultList = offerService.findAll();
		assertNotNull(resultList);
		assertFalse(resultList.isEmpty());
	}
	
	

}
