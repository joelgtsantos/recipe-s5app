/**
 * 
 */
package com.joelgtsantos.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.joelgtsantos.domain.UnitOfMeasure;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);

}
