package com.mms.blogs.demo.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mms.blogs.demo.SpringMVC.vo.User;

@Controller
@RequestMapping(value="/login",method=RequestMethod.POST)
@SessionAttributes(value="user",types=User.class)
public class LoginController {

	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public String authenticate(@RequestParam String userid, Model model){
		// effectively you can put your any LoginService here to authenticate user
		User user = new User();
		user.setUserid(userid);
		user.setFirstName("Manik");
		user.setLastName("M");
		// Since we have defined SessionAttribute user, this object will be stored at SessionLevel
		model.addAttribute("user", user);
		
		return "Home";
	}
	
}
