package com.felipeapn.msscbrewery.api.services;

import java.util.UUID;

import com.felipeapn.msscbrewery.api.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDTO);

	void updateBeer(UUID customerId, CustomerDto customerDTO);

	void deleteById(UUID customerId);

}
