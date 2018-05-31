/**
 * 
 */
package com.joelgtsantos.services;

import com.joelgtsantos.commands.IngredientCommand;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface IngredientService {
	
	IngredientCommand findByRecipeIdAndIngredientId(Long idRecipe, Long idIngredient);
	IngredientCommand saveIngredientCommand(IngredientCommand command);

	/**
	 * @param recipeId
	 * @param id
	 */
	void deleteById(long recipeId, long id);

}
