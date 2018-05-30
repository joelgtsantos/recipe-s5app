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
public class UnitOfMeasureToUnitOfMeasureCommandTest {
	public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

	/**
	 * Test method for {@link com.joelgtsantos.converters.UnitOfMeasureToUnitOfMeasureCommand#convert(com.joelgtsantos.domain.UnitOfMeasure)}.
	 */
	@Test
	public void testConvert() {
		//given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommand uomc = converter.convert(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
	}

}
