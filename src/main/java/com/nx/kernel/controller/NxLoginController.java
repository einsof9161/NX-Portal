package com.nx.kernel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.service.NxEmployeeService;
import com.nx.kernel.service.NxSysMenuService;
import com.nx.kernel.service.NxUserProfileService;
import com.nx.kernel.utils.PasswordEncodingGenerator;



@Controller
@SessionAttributes("sessionUserBean")
public class NxLoginController {

	@Autowired
	NxEmployeeService<NxEmployee> empServices;
	
	@Autowired
	NxUserProfileService userProfileService;
	
	@Autowired
	NxSysMenuService menuServices;
	
	
	
	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println("currentPrincipalName"+currentPrincipalName);
		if(null!=principal&&principal instanceof UserDetails){
			System.out.println("Set Model Attr...principal		"+principal+principal.getClass());
			model.addAttribute("user", principal);
			UserDetails userInfo = (UserDetails)principal;
			model.addAttribute("user", userInfo.getUsername());
			model.addAttribute("title", "main");
			model.addAttribute("sessionUserBean",empServices.findByAccount(userInfo.getUsername()));
		}
		List<NxSysMenu> menuList = menuServices.findAll();
		model.addAttribute("menus",menuList);
		return "kernel/index";
	}

	@RequestMapping(value = "/pageNotFound", method = RequestMethod.GET)
	public String pageNotFound(ModelMap model) {
		return "error/404";
	}
	
	@RequestMapping(value = "/serverError", method = RequestMethod.GET)
	public String serverError(ModelMap model) {
		return "error/500";
	}
	

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "kernel/accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("title", "Log In");
		return "kernel/login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String initRegisterForm (Model model) {
		NxEmployee empForm = new NxEmployee();
		model.addAttribute("register", empForm);
		initGenderList(model);
		return "kernel/register";
	}
	
	private void initGenderList(Model model) {
		// TODO Auto-generated method stub
		List<String> gerderList = new ArrayList<String>();
		gerderList.add("Male");
		gerderList.add("Femele"); 
		model.addAttribute("gerderList", gerderList);
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */ 
	@RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
	public String saveRegistration(@ModelAttribute("register") @Valid NxEmployee emp,BindingResult result,Model model) {
		 
		if (result.hasErrors()) { return "kernel/register"; }
		System.out.println(".......2"+emp);
		System.out.println("model.message2"+model);
		emp.setPassword(PasswordEncodingGenerator.encoder(emp.getPassword()));
		empServices.save(emp);
		model.addAttribute("message","帳號建立成功.請登入系統！");
		return "redirect:/login?success";
	}


	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("getPrincipal#######"+principal);
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	//@ModelAttribute("roles")
	public List<NxUserProfile> initializeProfiles() {
		System.out.println("#######initializeProfiles");
		return userProfileService.findAll();
	}


	
}
