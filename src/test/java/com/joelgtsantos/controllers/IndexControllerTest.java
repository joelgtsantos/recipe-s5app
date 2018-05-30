/**
 * 
 */
package com.joelgtsantos.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.joelgtsantos.domain.Recipe;
import com.joelgtsantos.services.RecipeService;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class IndexControllerTest {
	
	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}
	
	@Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

	@Test
	public void getIndexPage() {
		
		//given
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when		
		String viewName = indexController.getIndexPage(model);
		
		//then
		assertEquals(viewName, "index");
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(setInController.size(), 1);
		
	}

}
