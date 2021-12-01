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
import com.codeimmig.yannick.entity.Coupon;
import com.codeimmig.yannick.exception.CouponNotFoundException;
import com.codeimmig.yannick.service.ICouponService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/coupon")
@Controller
@Slf4j
public class CouponController {
	@Autowired
	private ICouponService service;
	//1. show Register page
			@GetMapping("register")
			public String showReg() {
				return "CouponRegister";
			}
			
			/**
			 * 
			 * @param coupon
			 * @param model
			 * @return
			 */
			@PostMapping("/save")
			public String saveBrand(
					@ModelAttribute Coupon coupon,
					Model model
					) 
			{
				Long id = service.saveCoupon(coupon);
				String message = "Coupon '"+id+"' is created";
				model.addAttribute("message", message);
				return "CouponRegister";
			}
			
			@GetMapping("/all")
			public String getAllCoupon(Model model) {
				List<Coupon> list=service.getAllCoupons();
				model.addAttribute("list", list);
				return "CouponData";
			}
			/**
			 * 
			 * @param id
			 * @param attributes
			 * @return
			 */
			
			@GetMapping("/delete")
			public String deleteCoupon(@RequestParam("id") Long id, RedirectAttributes attributes) {
				try {
					log.info("ENTERED INTO DELETE METHOD");
					service.deleteCoupon(id);
					attributes.addAttribute("message", "Coupon delete with id : "+id);
					log.debug("BRAND DELETED WITH ID: {}",id);
				} catch (CouponNotFoundException e) {
					e.printStackTrace();
					log.error("ERORR IS : {}", e.getMessage() );
				}
				log.info("ABOUT TO LEAVE DELETE METHOD");
				return "redirect:all";
				
			}
			/**
			 * 
			 * @param id
			 * @param model
			 * @param attributes
			 * @return
			 */
			@GetMapping("/edit")
			public String editCoupon(@RequestParam Long id, Model model, RedirectAttributes attributes) {
				String page = null;
				try {
					Coupon ob = service.getOneCoupon(id);
					model.addAttribute("coupon", ob);
					page = "CouponEdit";
		
				} catch (CouponNotFoundException e) {
					e.printStackTrace();
					attributes.addAttribute("message", e.getMessage());
					page = "redirect:all";
				}
				return page;
			}

			@PostMapping("/update")
			public String updateCoupon(@ModelAttribute Coupon coupon, RedirectAttributes attributes) {
				service.updateCoupon(coupon);
				attributes.addAttribute("message", "Coupon  updated");
				return "redirect:all";
			}

}
