package com.prasad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.Model.User;
import com.prasad.Service.UserService;

@Controller
public class UserController {

@Autowired
UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(User user) {
		
		String usn = user.getEmail();
		String pwd = user.getPassword();

		ModelAndView mv=new ModelAndView();
	
		User loginUser = null;
		if(usn != null && pwd != null) {
			loginUser =userService.loginUser(user);
		}	if(usn == null || pwd == null) {
			mv.addObject("message", "Login Failed, UserName and Password should not be null or blank!");
			mv.setViewName("login");
		}else if(loginUser != null) {
			mv.addObject("message", "Login Successfull!");
			mv.setViewName("loginsucess");
			mv.addObject("getUser", loginUser);
		}else {
			mv.addObject("message", "Login Failed, Incorrect UserName or Password, Please try again!");
			mv.setViewName("login");
		}
		
		
		//User loginuser=userService.loginUser(user);
		
		
		return mv;
		}
	
	
	
}
