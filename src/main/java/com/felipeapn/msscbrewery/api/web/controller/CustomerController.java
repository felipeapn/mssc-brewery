package com.felipeapn.msscbrewery.api.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felipeapn.msscbrewery.api.services.CustomerService;
import com.felipeapn.msscbrewery.api.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer (@PathVariable UUID customerId) {
		
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity handlePost (@Valid @RequestBody CustomerDto customerDTO) {
		
		CustomerDto savedDTO = customerService.saveNewCustomer(customerDTO);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", "/api/v1/customer" + savedDTO.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID customerId, @Valid @RequestBody CustomerDto customerDTO) {
		
		customerService.updateBeer(customerId, customerDTO);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
		
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID customerId) {
		
		customerService.deleteById(customerId);
		
	}


}
