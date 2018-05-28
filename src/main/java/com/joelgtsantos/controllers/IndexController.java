/**
 * 
 */
package com.joelgtsantos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@Controller
public class IndexController {
	
	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {
		return "index";
	}

}
