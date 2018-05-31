/**
 * 
 */
package com.joelgtsantos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joelgtsantos.commands.IngredientCommand;
import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.services.IngredientService;
import com.joelgtsantos.services.RecipeService;
import com.joelgtsantos.services.UnitOfMeasureService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Controller
@Slf4j
public class IngredientController {
	
	private final RecipeService recipeService;
	private final IngredientService ingredientService;
	private final UnitOfMeasureService unitOfMeasureService;
	
	
	/**
	 * @param recipeService
	 * @param ingredientService 
	 */
	public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
		this.unitOfMeasureService = unitOfMeasureService;
	}


	@GetMapping
	@RequestMapping("/recipe/{id}/ingredient")
	public String listIngredients(@PathVariable String id, Model model) {
		RecipeCommand recipeCommand = this.recipeService.findCommandById(new Long(id));
		model.addAttribute("recipe", recipeCommand);
		return "recipe/ingredient/list";
	}
	
	@GetMapping
	@RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}")
	public String showIngredient(@PathVariable String recipeId,
								@PathVariable String ingredientId, 
								Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(new Long(recipeId), new Long(ingredientId)));
		
		return "recipe/ingredient/show";
	}
	
	@GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("uomList", unitOfMeasureService.listUom());
        return "recipe/ingredient/ingredientform";
    }
	
	@PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId();
    }

}
