package com.yash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedbackController {

	@RequestMapping(value="showfeedback")
	public String showFeedbackForm(){
		
		return "showFeedbackForm";
	}
}
