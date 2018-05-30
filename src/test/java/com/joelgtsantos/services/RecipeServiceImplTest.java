/**
 * 
 */
package com.joelgtsantos.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.joelgtsantos.domain.Recipe;
import com.joelgtsantos.repositories.RecipeRepository;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}
	
	
	@Test
	public void getRecipes() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeServiceImpl.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
