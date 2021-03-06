/**
 * 
 */
package com.joelgtsantos.services;

import java.util.Set;

import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.domain.Recipe;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface RecipeService {
	
	Set<Recipe> getRecipes();
	
	Recipe findById(Long l);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);
	
	RecipeCommand findCommandById(Long l);
	
	void deleteById(Long l);

}
