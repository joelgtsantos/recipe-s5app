/**
 * 
 */
package com.joelgtsantos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class RecipeController {
	RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/{id}")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		
		return "recipe/show";
	}
	
	@RequestMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe",new RecipeCommand());
		
		return "recipe/recipeform";
	}
	
	@PostMapping
	@RequestMapping("recipe")
	public String saveUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand saveCommand = recipeService.saveRecipeCommand(command);
		
		return "redirect:/recipe/" + saveCommand.getId(); 
	}
	
	@RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }
	
	
}
