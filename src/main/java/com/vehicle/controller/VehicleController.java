package com.vehicle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.service.VehicleService;
import com.vehicle.utils.LoginValidator;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	   @Autowired
	   private LoginValidator loginValidator;
	   
	   @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(loginValidator);
	   }
	
	private static final Logger logger = LoggerFactory
	        .getLogger(VehicleController.class);
		
			
	 @RequestMapping(value="/", method = RequestMethod.GET)
	    public ModelAndView welcome(ModelMap model) {
		 logger.info("Inside the startup method");
		   ModelAndView mv = new ModelAndView();
		   //return "redirect:/users";
	       mv.setViewName("VehicleHome");
	       return mv;
	    }
	 
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public ModelAndView login(ModelMap model) {
		 logger.info("Inside the login method");
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("loginForm", new LoginDTO());
		   mv.setViewName("Login");
	       return mv;
	    }
	 
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public ModelAndView authenticate(@ModelAttribute("loginForm")@Validated LoginDTO login,
				BindingResult result, Model model,
				final RedirectAttributes redirectAttributes) {
		   logger.info("Inside the authenticate method");
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("Login");
		   if (result.hasErrors()) {
			   mv.setViewName("Login");
		      }else {
		    	 Login user= vehicleService.authenticate(login);
		    	 mv.addObject("user",user);
		    	 mv.setViewName("VehicleHome");
		      }
		return mv;
	    }

}
