package com.mms.blogs.demo.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mms.blogs.demo.SpringMVC.vo.User;

@Controller
@SessionAttributes(value="user",types=User.class)
@RequestMapping(value="/echo")
public class EchoUserController {

	@RequestMapping(value="/getuser",method=RequestMethod.POST)
	public @ResponseBody User getUser(@ModelAttribute("user") User user, BindingResult result, Model model){
		
		if(user == null){
			throw new RuntimeException("User not found");
		}
		
		return user;
	}
	
	
}
