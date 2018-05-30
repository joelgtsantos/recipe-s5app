/**
 * 
 */
package com.joelgtsantos.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.joelgtsantos.commands.CategoryCommand;
import com.joelgtsantos.domain.Category;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class CategoryToCategoryCommandTest {
	public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand convter;

    @Before
    public void setUp() throws Exception {
        convter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convter.convert(new Category()));
    }
    
	/**
	 * Test method for {@link com.joelgtsantos.converters.CategoryToCategoryCommand#convert(com.joelgtsantos.domain.Category)}.
	 */
	@Test
	public void testConvert() {
		//given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
	}

}
