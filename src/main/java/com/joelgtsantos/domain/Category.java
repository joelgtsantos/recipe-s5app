/**
 * 
 */
package com.joelgtsantos.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Data
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
