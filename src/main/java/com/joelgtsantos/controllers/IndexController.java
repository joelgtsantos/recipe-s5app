/**
 * 
 */
package com.joelgtsantos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joelgtsantos.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		log.debug("Enter mapping index");
		model.addAttribute("recipes", this.recipeService.getRecipes());
		
		return "index";
	}

}
