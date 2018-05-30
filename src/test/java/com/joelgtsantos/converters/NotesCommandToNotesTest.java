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
public class NotesCommandToNotesTest {
	
	public static final Long ID_VALUE = new Long(1L);
	public static final String RECIPE_NOTES = "Notes";
	NotesCommandToNotes converter;

	@Before
	public void setUp() throws Exception {
		converter = new NotesCommandToNotes();

	}

	@Test
	public void testNullParameter() throws Exception {
		assertNotNull(converter.convert(new NotesCommand()));
	}

	/**
	 * Test method for {@link com.joelgtsantos.converters.NotesCommandToNotes#convert(com.joelgtsantos.commands.NotesCommand)}.
	 */
	@Test
	public void testConvert() {
		//given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
	}

}
