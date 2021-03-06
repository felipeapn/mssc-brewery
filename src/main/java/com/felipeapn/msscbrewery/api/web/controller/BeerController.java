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

import com.felipeapn.msscbrewery.api.services.BeerService;
import com.felipeapn.msscbrewery.api.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity handlePost (@Valid @RequestBody BeerDto beerDto) {
		
		BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {
		
		beerService.updateBeer(beerId, beerDto);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		
		beerService.deleteById(beerId);
		
	}
	
}
