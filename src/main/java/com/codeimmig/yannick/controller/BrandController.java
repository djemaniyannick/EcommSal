package com.codeimmig.yannick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeimmig.yannick.entity.Brand;
import com.codeimmig.yannick.exception.BrandNotFoundException;
import com.codeimmig.yannick.service.IBrandService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private IBrandService service;
	//1. show Register page
		@GetMapping("register")
		public String showReg() {
			return "BrandRegister";
		}
		
		//2. save brand 
		@PostMapping("/save")
		public String saveBrand(
				@ModelAttribute Brand brand,
				Model model
				) 
		{
			Long id = service.saveBrand(brand);
			String message = "Brand '"+id+"' is created";
			model.addAttribute("message", message);
			return "BrandRegister";
		}
		
		//3. fetch all brands
		@GetMapping("/all")
		public String getAllBrands(Model model) 
		{
			List<Brand> list = service.getAllBrands();
			model.addAttribute("list", list);
			return "BrandData";
		}
		
		@GetMapping("/delete")
		public String deleteCategory(@RequestParam Long id, RedirectAttributes attributes) {
			log.info("ENTERED INTO DELETE METHOD");
			try {
				service.deleteBrand(id);
				attributes.addAttribute("message", "Category deleted with Id:" + id);
				log.debug("BRAND DELETED WITH ID: {}",id);
			} catch (BrandNotFoundException e) {
				e.printStackTrace();
				attributes.addAttribute("message", e.getMessage());
				log.error("ERORR IS : {}", e.getMessage() );
			}
			log.info("ABOUT TO LEAVE DELETE METHOD");
			return "redirect:all";
		}
		
		@GetMapping("/edit")
		public String editCategory(@RequestParam Long id, Model model, RedirectAttributes attributes) {
			String page = null;
			try {
				Brand ob = service.getOneBrand(id);
				model.addAttribute("brand", ob);
				page = "BrandEdit";
			} catch (BrandNotFoundException e) {
				e.printStackTrace();
				attributes.addAttribute("message", e.getMessage());
				page = "redirect:all";
			}
			return page;
		}

		@PostMapping("/update")
		public String updateBrand(@ModelAttribute Brand brand, RedirectAttributes attributes) {
			service.updateBrand(brand);
			attributes.addAttribute("message", "Brand updated");
			return "redirect:all";
		}
}
