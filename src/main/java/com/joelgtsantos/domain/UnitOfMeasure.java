/**
 * 
 */
package com.joelgtsantos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Data
@Entity
public class UnitOfMeasure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
}
