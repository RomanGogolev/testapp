package org.student.testapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.student.testapp.dao.UserManager;
import org.student.testapp.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "redirect:/sign-in";
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String login(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString().equals("ROLE_ANONYMOUS")){
			return "index";
		} else return "redirect:/welcome";
	}

	@RequestMapping(value = "/sign-in-error", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("error","Username or password not correct");
		return "index";
	}


	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String registrationPage(Model model) {
		return "registration";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("name", user.getUsername());
		return "welcome";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String registration(@RequestParam String username, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {
		if(!UserManager.used(username)) {
			Pattern p1 = Pattern.compile("((?=.*\\d)(?=.*[A-Za-z]).{5,32})");
			Matcher matcher1 = p1.matcher(username);
			if(matcher1.matches()) {
				if (password.equals(confirmPassword)) {
					Pattern p2 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})");
					Matcher matcher2 = p2.matcher(password);
					if(matcher2.matches()){
						User user = new User();
						user.setUsername(username);
						user.setPassword(bCryptPasswordEncoder.encode(password));
						user.setRoles("ROLE_USER");
						UserManager.create(user);
						return "redirect:/";
					}else model.addAttribute("error4","Password is not correct");
				} else model.addAttribute("error3", "Passwords are different");
			}else model.addAttribute("error2","Username is not correct");
		} else model.addAttribute("error1", "Username is using");
		return "registration";
	}
}
