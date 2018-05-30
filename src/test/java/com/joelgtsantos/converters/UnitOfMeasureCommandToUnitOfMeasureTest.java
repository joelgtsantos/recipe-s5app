/**
 * 
 */
package com.joelgtsantos.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.joelgtsantos.commands.UnitOfMeasureCommand;
import com.joelgtsantos.domain.UnitOfMeasure;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {
	
	public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }


	/**
	 * Test method for {@link com.joelgtsantos.converters.UnitOfMeasureCommandToUnitOfMeasure#convert(com.joelgtsantos.commands.UnitOfMeasureCommand)}.
	 */
	@Test
	public void testConvert() {
		//given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
	}

}
