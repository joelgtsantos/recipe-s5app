/**
 * 
 */
package com.joelgtsantos.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.joelgtsantos.commands.NotesCommand;
import com.joelgtsantos.domain.Notes;

import lombok.Synchronized;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}