package com.codeimmig.yannick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeimmig.yannick.entity.AppUser;
import com.codeimmig.yannick.service.IAppUserService;

@Controller
@RequestMapping("/appuser")
public class AppuserController {
	@Autowired
	private IAppUserService service;
	
	@GetMapping("/register")
	public String register() {
		return "AppUserRegister";	
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute AppUser appUser, Model model) {
		Long id=service.saveAppUser(appUser);
		model.addAttribute("message", "User" +id+ " is created");
		return "AppUserRegister";
	}
	
	@GetMapping("/all")
	public String showData(Model model) {
		model.addAttribute("list", service.getAllAppUser());
		return "AppUserData";
	}
}
