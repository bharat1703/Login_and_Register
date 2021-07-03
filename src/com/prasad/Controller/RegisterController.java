package com.prasad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.Model.Register;
import com.prasad.Service.RegisterService;

@Controller
public class RegisterController {

	System.out.println("i am from controller");	

	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/")
	public String main() {
		return "index.jsp";
	}
	
	@RequestMapping("/register")
	public ModelAndView register(Register register) {
		System.out.println("hi i am from controller"+register);
		boolean addUser=registerService.addUser(register);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("registersucess");
		mv.addObject("message","Registration is done for the following details :");
		mv.addObject("register", register);
		return mv;
	}
	
}
