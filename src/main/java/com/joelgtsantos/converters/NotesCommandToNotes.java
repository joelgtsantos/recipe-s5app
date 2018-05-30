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
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}