package com.felipeapn.msscbrewery.api.web.mapper;

import org.mapstruct.Mapper;

import com.felipeapn.msscbrewery.api.domain.Beer;
import com.felipeapn.msscbrewery.api.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	 BeerDto beerToBeerDto(Beer beer);
	 
	 Beer berrDtoToBeer(BeerDto dto);
}
