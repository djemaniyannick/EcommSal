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

import com.codeimmig.yannick.entity.CategoryType;
import com.codeimmig.yannick.exception.CategoryTypeNotFoundException;
import com.codeimmig.yannick.service.ICategoryTypeService;
@Controller
@RequestMapping("/categorytype")
public class CategoryTypeController {
	@Autowired
	private ICategoryTypeService service;

	@GetMapping("/register")
	public String registerCategoryType(Model model) {
		return "CategoryTypeRegister";
	}
	
	@PostMapping("/save")
	public String saveCategoryType(@ModelAttribute CategoryType categoryType, Model model) {
		Long id=service.saveCategoryType(categoryType);
		model.addAttribute("message", "Category created with id :"+id);
		model.addAttribute("categorytype", new CategoryType());
		return "CategoryTypeRegister";
	}
	
	/**
	 * 
	 * @param model
	 * @param message
	 * @return
	 */
	@GetMapping("/all")
	public String getAllCategory(Model model, @RequestParam(value ="message", required = false)String message) {
	List<CategoryType>	list=service.getAllCategoryTypes();
	model.addAttribute("list", list);
	model.addAttribute("message", message);
	return "CategoryTypeData";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete")
	public String deleteCategoryType(@RequestParam Long id , Model model, RedirectAttributes attributes) {
		try {
			service.deleteCategoryType(id);
			attributes.addAttribute("message","Category delete with Id: "+id);
			
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String editCategoryType(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		String page=null;
		try {
			CategoryType ob=service.getOneCategoryType(id);
			model.addAttribute("categorytype", ob);
			page="CategoryTypeEdit";
			
		} catch (CategoryTypeNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page="redirect:all";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute CategoryType categoryType, RedirectAttributes attributes) {
		service.updateCategoryType(categoryType);
		attributes.addAttribute("message", "CategoryType update");
		return "redirect:all";	
	}
}
