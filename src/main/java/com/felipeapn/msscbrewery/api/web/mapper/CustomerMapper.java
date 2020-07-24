package com.felipeapn.msscbrewery.api.web.mapper;

import org.mapstruct.Mapper;

import com.felipeapn.msscbrewery.api.domain.Customer;
import com.felipeapn.msscbrewery.api.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	
	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDto dto);

}
