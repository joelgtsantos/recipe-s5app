/**
 * 
 */
package com.joelgtsantos.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Joel Santos
 *
 * recipe-app 2018
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
	private Long id;
	private String description;
}