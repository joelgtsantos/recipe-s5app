/**
 * 
 */
package com.joelgtsantos.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
public interface ImageService {

	/**
	 * @param anyLong
	 * @param any
	 */
	void saveImageFile(long recipeId, MultipartFile file);

}
