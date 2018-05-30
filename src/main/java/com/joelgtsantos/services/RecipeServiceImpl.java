/**
 * 
 */
package com.joelgtsantos.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.converters.RecipeCommandToRecipe;
import com.joelgtsantos.converters.RecipeToRecipeCommand;
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
	
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
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

	/* Get recipe by Id
	 * @see com.joelgtsantos.services.RecipeService#getRecipeById()
	 */
	@Override
	public Recipe findById(Long l) {
		Optional<Recipe> recipe = this.recipeRepository.findById(l);
		
		if (!recipe.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }
		
		return recipe.get();
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.RecipeService#saveRecipeCommand(com.joelgtsantos.commands.RecipeCommand)
	 */
	@Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

	/*
	 * @see com.joelgtsantos.services.RecipeService#findCommandById(java.lang.Long)
	 */
	@Transactional
	@Override
	public RecipeCommand findCommandById(Long l) {
		return recipeToRecipeCommand.convert(findById(l));
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.RecipeService#deleteById(java.lang.Long)
	 */
	@Override
	public void  deleteById(Long l) {
		recipeRepository.deleteById(l);
	}

}
