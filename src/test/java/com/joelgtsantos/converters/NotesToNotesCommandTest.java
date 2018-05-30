/**
 * 
 */
package com.joelgtsantos.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.joelgtsantos.commands.NotesCommand;
import com.joelgtsantos.domain.Notes;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public class NotesToNotesCommandTest {
	
	public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    /**
	 * Test method for {@link com.joelgtsantos.converters.NotesToNotesCommand#convert(com.joelgtsantos.domain.Notes)}.
	 */
    @Test
    public void testConvert() throws Exception {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }
    
    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

}
