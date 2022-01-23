package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping(value = "/hello")
    public String home(@PathVariable String name, Model model){
 		model.addAttribute("name", name);
 		return "home/home";
	}

	
	@PostMapping("/signup")
    public String showSignUpForm(UserEntity user) {
        return "user/add_user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add_user";
        }
        
        userRepository.save(user);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }
    @RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}
}
