/**
 * 
 */
package com.joelgtsantos.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.joelgtsantos.domain.Recipe;
import com.joelgtsantos.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	/*
	 * @see com.joelgtsantos.services.RecipeService#getRecipes()
	 */
	@Override
	public Set<Recipe> getRecipes() {
		log.debug("Slf4j log in the service	");
		Set<Recipe> recipes = new HashSet<>();
		this.recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

}
