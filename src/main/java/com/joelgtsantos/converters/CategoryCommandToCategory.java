/**
 * 
 */
package com.joelgtsantos.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.joelgtsantos.commands.CategoryCommand;
import com.joelgtsantos.domain.Category;

import lombok.Synchronized;

/**
 * @author Joel Santos
 *
 * recipe-app 2018
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {
		if (source == null) {
			return null;
		}

		final Category category = new Category();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}
}