/**
 * 
 */
package com.joelgtsantos.controllers;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.joelgtsantos.commands.IngredientCommand;
import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.services.IngredientService;
import com.joelgtsantos.services.RecipeService;
import com.joelgtsantos.services.UnitOfMeasureService;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class IngredientControllerTest {
	
	IngredientController ingredientController;
	
	MockMvc mockMvc;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	IngredientService ingredientService;
	
	@Mock
	UnitOfMeasureService uomService;
	
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ingredientController = new IngredientController(recipeService, ingredientService, uomService);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
	}

	@Test
	public void testListIngredients() throws Exception {
		//given
		RecipeCommand recipeCommand = new RecipeCommand();
		when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
		
		//when
		mockMvc.perform(get("/recipe/1/ingredient"))
			.andExpect(status().isOk())
			.andExpect(view().name("recipe/ingredient/list"))
			.andExpect(model().attributeExists("recipe"));
		
		//then
		verify(recipeService, times(1)).findCommandById(anyLong());
	}
	
	@Test
	public void testShowIngredient() throws Exception {
		//given
		IngredientCommand ingredientCommand = new IngredientCommand();
		
		//when
		when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);
		
		//then
		mockMvc.perform(get("/recipe/1/ingredient/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("recipe/ingredient/show"))
			.andExpect(model().attributeExists("ingredient"));
		
	}
	
	@Test
    public void testUpdateIngredientForm() throws Exception {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();

        //when
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);
        when(uomService.listUom()).thenReturn(new HashSet<>());

        //then
        mockMvc.perform(get("/recipe/1/ingredient/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));
    }
	
	 @Test
    public void testSaveOrUpdate() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        //when
        when(ingredientService.saveIngredientCommand(any())).thenReturn(command);

        //then
        mockMvc.perform(post("/recipe/2/ingredient")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredient/3"));

    }
	 
	@Test
    public void testDeleteAction() throws Exception {
        mockMvc.perform(get("/recipe/2/ingredient/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredient"));

        verify(ingredientService, times(1)).deleteById(anyLong(), anyLong());
    }
}
