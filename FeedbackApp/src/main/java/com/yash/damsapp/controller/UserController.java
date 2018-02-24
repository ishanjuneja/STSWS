package com.yash.damsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * this controller will perform all controlling related to a user
 * @author ishan.juneja
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="home.htm",method=RequestMethod.GET)
	public String showHomePage(){
		return "home";
	}
}
