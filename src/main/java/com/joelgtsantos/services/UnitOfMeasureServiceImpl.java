/**
 * 
 */
package com.joelgtsantos.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.joelgtsantos.commands.UnitOfMeasureCommand;
import com.joelgtsantos.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.joelgtsantos.repositories.UnitOfMeasureRepository;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
	
	private final UnitOfMeasureRepository uomRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;
	
	
	public UnitOfMeasureServiceImpl(UnitOfMeasureRepository uomRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		this.uomRepository = uomRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;

	}

	/*
	 * @see com.joelgtsantos.services.UnitOfMeasureService#listUom()
	 */
	@Override
	public Set<UnitOfMeasureCommand> listUom() {
		return StreamSupport.stream(uomRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
	}

}
