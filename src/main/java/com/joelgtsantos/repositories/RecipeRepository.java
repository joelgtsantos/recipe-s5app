/**
 * 
 */
package com.joelgtsantos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.joelgtsantos.domain.Recipe;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	

}
