package com.palyga.web;

import com.palyga.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public String login(Model map){
		map.addAttribute("newUser",new Users());
		return "signin";
	}

	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(){
		return "redirect:/j_spring_security_logout";
	}

}
