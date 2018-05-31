/**
 * 
 */
package com.joelgtsantos.commands;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Joel Santos
 *
 * recipe-app 2018
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
	private Long id;
	private Long recipeId;
	private String description;
	private BigDecimal amount;
	private UnitOfMeasureCommand uom;

}