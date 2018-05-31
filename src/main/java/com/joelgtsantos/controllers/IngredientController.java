/**
 * 
 */
package com.joelgtsantos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.services.RecipeService;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Controller
public class IngredientController {
	
	RecipeService recipeService;
	
	
	/**
	 * @param recipeService
	 */
	public IngredientController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}


	@GetMapping
	@RequestMapping("/recipe/{id}/ingredients")
	public String listIngredients(@PathVariable String id, Model model) {
		RecipeCommand recipeCommand = this.recipeService.findCommandById(new Long(id));
		model.addAttribute("recipe", recipeCommand);
		return "recipe/ingredient/list";
	}

}
