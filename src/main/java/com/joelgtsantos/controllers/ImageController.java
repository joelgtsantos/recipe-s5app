/**
 * 
 */
package com.joelgtsantos.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.joelgtsantos.commands.RecipeCommand;
import com.joelgtsantos.services.ImageService;
import com.joelgtsantos.services.ImageServiceImpl;
import com.joelgtsantos.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Slf4j
@Controller
public class ImageController {
	
	ImageService imageService;
	RecipeService recipeService;

	/**
	 * @param imageService
	 * @param recipeService
	 */
	public ImageController(ImageService imageService, RecipeService recipeService) {
		// TODO Auto-generated constructor stub
		this.imageService = imageService;
		this.recipeService = recipeService;
	}
	
	@GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/imageForm";
    }
	
	@PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);

        return "redirect:/recipe/" + id;
    }
	
	@GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

        log.debug("images");
       
        
        if (recipeCommand.getImage() != null) {
            byte[] byteArray = new byte[recipeCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}
