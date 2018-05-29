/**
 * 
 */
package com.joelgtsantos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.joelgtsantos.domain.Category;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
