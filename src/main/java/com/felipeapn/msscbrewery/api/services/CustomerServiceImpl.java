package com.felipeapn.msscbrewery.api.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.felipeapn.msscbrewery.api.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Felipe")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDTO) {
		
		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID customerId, CustomerDto customerDTO) {
		//todo impl - would add a real impl to update customer
		
	}

	@Override
	public void deleteById(UUID customerId) {
	
		log.debug("Deleting customer");
		
	}

}
