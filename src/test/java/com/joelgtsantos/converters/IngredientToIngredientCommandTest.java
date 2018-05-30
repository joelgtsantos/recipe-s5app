/**
 * 
 */
package com.joelgtsantos.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.joelgtsantos.commands.IngredientCommand;
import com.joelgtsantos.domain.Ingredient;
import com.joelgtsantos.domain.Recipe;
import com.joelgtsantos.domain.UnitOfMeasure;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class IngredientToIngredientCommandTest {
	public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = new Long(2L);
    public static final Long ID_VALUE = new Long(1L);


    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

	/**
	 * Test method for {@link com.joelgtsantos.converters.IngredientToIngredientCommand#IngredientToIngredientCommand(com.joelgtsantos.converters.UnitOfMeasureToUnitOfMeasureCommand)}.
	 */
	@Test
	public void testConvertNullUOM() {
		//given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);
        
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        
        //then
        assertNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}

	/**
	 * Test method for {@link com.joelgtsantos.converters.IngredientToIngredientCommand#convert(com.joelgtsantos.domain.Ingredient)}.
	 */
	@Test
	public void testConvert() {
		//given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setUom(uom);
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}

}
