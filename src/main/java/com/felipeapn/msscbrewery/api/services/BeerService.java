package com.felipeapn.msscbrewery.api.services;

import java.util.UUID;

import com.felipeapn.msscbrewery.api.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteById(UUID beerId);

}
