package com.vehicle.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;
import com.vehicle.service.VehicleService;
import com.vehicle.utils.LoginValidator;
import com.vehicle.utils.VehicleValidator;


@Controller
@SessionAttributes("user")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	
	   @Autowired
	   private LoginValidator loginValidator;
	   
	   @Autowired
	   private VehicleValidator vehicleValidator;
	   
	   @InitBinder("loginform")
	   protected void loginBinder(WebDataBinder binder) {
	      binder.addValidators(loginValidator);
	   }
	   
	   @InitBinder("vehicleForm")
	   protected void vehicleBinder(WebDataBinder binder) {
	      binder.addValidators(vehicleValidator);
	   }
	
	private static final Logger logger = LoggerFactory
	        .getLogger(VehicleController.class);
		
			
	 @RequestMapping(value="/", method = RequestMethod.GET)
	    public ModelAndView welcome(ModelMap model) {
		 logger.info("Inside the startup method");
		   ModelAndView mv = new ModelAndView();
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
	 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logout(ModelMap model,HttpSession session,final RedirectAttributes redirectAttributes) {
		 logger.info("Inside the lgout method");
		   ModelAndView mv = new ModelAndView();
		   session.removeAttribute("userDetails");
		   redirectAttributes.addFlashAttribute("user", new Login());
		   return  "redirect:/";
	    }
	 
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public ModelAndView authenticate(@ModelAttribute("loginForm")@Validated LoginDTO login,
				BindingResult result, Model model,
				final RedirectAttributes redirectAttributes,HttpSession session) {
		   logger.info("Inside the authenticate method");
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("Login");
		   if (result.hasErrors()) {
			   mv.setViewName("Login");
		      }else {
		    	 Login user= vehicleService.authenticate(login);;		    	 
		    	 session.setAttribute("userDetails", user);
		    	 mv.addObject("user",user);
		    	 mv.addObject("msg","");
		    	 mv.setViewName("VehicleHome");
		      }
		return mv;
	    }
	 
	 @RequestMapping(value="/newVehicle", method = RequestMethod.GET)
	    public ModelAndView vehicleForm(HttpSession session) {
		 logger.info("Inside the vehicle form method");
		   ModelAndView mv = new ModelAndView();
		   //userDetails
		   mv.addObject("vehicleForm", new VehicleDTO());
		   mv.setViewName("VehicleForm");
	       return mv;
	    }
	 
	 @RequestMapping(value="/newVehicle", method = RequestMethod.POST)
	    public String createVehicle(@ModelAttribute("vehicleForm")@Validated VehicleDTO vehicle,
				BindingResult result, Model model,HttpSession session,
				final RedirectAttributes redirectAttributes) {
		   logger.info("Inside the create vehicle method");
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("VehicleHome");
		   Login loggedUser=(Login) session.getAttribute("userDetails");
		   if (result.hasErrors()) {
			   return "VehicleForm" ;
		      }else {
					String status=vehicleService.addVehicle(vehicle,loggedUser.getName());
					redirectAttributes.addFlashAttribute("msg", status);

		      }
		return  "redirect:/";
	    }
	 
	 @RequestMapping(value="/view", method = RequestMethod.GET)
	    public ModelAndView viewVehicle() {
		   logger.info("Inside the view vehicle method");
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("VehicleList");
		   List<Vehicle> vehicles=vehicleService.listVehicles();
		   mv.addObject("vehicle", vehicles);
		return  mv;
	    }
	 
	 
		// delete vehicle
		@RequestMapping(value = "/vehicle/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id,
			final RedirectAttributes redirectAttributes) {

			logger.debug("deletevehicle() : {}", id);

			String status=vehicleService.delete(id);

			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", status);

			return "redirect:/view";

		}
		
		@RequestMapping(value = "/vehicle/{id}/update", method = RequestMethod.GET)
		public String update(@PathVariable("id") int id, Model model,
				final RedirectAttributes redirectAttributes) {

			logger.debug("updatevehicle() : {}", id);
			ModelAndView mv = new ModelAndView();
			Vehicle vehicle= vehicleService.findById(id);
			redirectAttributes.addFlashAttribute("vehicleForm", vehicle);
			return "redirect:/updateVehicle";

		}
		
		 @RequestMapping(value="/updateVehicle", method = RequestMethod.GET)
		    public ModelAndView updateVehicle() {
			 logger.info("Inside the update redirect method");
			   ModelAndView mv = new ModelAndView();
			   mv.setViewName("VehicleForm");
		       return mv;
		    }
		 
		 
		 @RequestMapping(value="/trackVehicle", method = RequestMethod.GET)
		    public ModelAndView trackVehicle(HttpSession session) {
			 logger.info("Inside the track vehicle method");
			   ModelAndView mv = new ModelAndView();
			   Login loggedUser=(Login) session.getAttribute("userDetails");
			   List<Vehicle> vehicle=vehicleService.findbyUser(loggedUser.getName());
			   mv.addObject("allVehicles", vehicle);
			   mv.setViewName("VehicleTracking");
		       return mv;
		    }
	
	 
	 

}
