/**
 * 
 */
package com.joelgtsantos.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class CategoryTest {
	
	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}
	
	/**
	 * Test method for {@link com.joelgtsantos.domain.Category#getId()}.
	 */
	@Test
	public void testGetId() throws Exception{
		Long idValue = 4L;
		
		category.setId(idValue);
		
		assertEquals(idValue, category.getId());
	}

	/**
	 * Test method for {@link com.joelgtsantos.domain.Category#getDescription()}.
	 */
	@Test
	public void testGetDescription() throws Exception{
	}

	/**
	 * Test method for {@link com.joelgtsantos.domain.Category#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() throws Exception{
	}

}
