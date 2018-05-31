/**
 * 
 */
package com.joelgtsantos.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.joelgtsantos.domain.Recipe;
import com.joelgtsantos.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joel Santos
 *
 *         recipe-app 2018
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	private final RecipeRepository recipeRepository;

	public ImageServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	/*
	 * @see com.joelgtsantos.services.ImageService#saveImageFile(long,
	 * java.lang.Object)
	 */
	@Override
	@Transactional
	public void saveImageFile(long recipeId, MultipartFile file) {
		try {
			Recipe recipe = recipeRepository.findById(recipeId).get();

			Byte[] byteObjects = new Byte[file.getBytes().length];

			int i = 0;

			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}

			recipe.setImage(byteObjects);

			recipeRepository.save(recipe);
		} catch (IOException e) {
			// todo handle better
			log.error("Error occurred", e);

			e.printStackTrace();
		}

	}

}