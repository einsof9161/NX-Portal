package com.nx.kernel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.model.user.NxUser;
import com.nx.kernel.service.NxEmployeeService;
import com.nx.kernel.service.NxSysMenuService;
import com.nx.kernel.service.NxUserProfileService;
import com.nx.kernel.service.NxUserService;


public class NxSystemController {

	@Autowired
	NxEmployeeService<NxEmployee> empServices;
	
	@Autowired
	NxUserProfileService userProfileService;
	
	@Autowired
	NxSysMenuService menuServices;
	
	@Autowired
	NxUserService userService;
	
	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(null!=principal&&principal instanceof UserDetails){
			System.out.println("Set Model Attr...principal		"+principal+principal.getClass());
			model.addAttribute("user", principal);
			UserDetails userInfo = (UserDetails)principal;
			model.addAttribute("user", userInfo.getUsername());
			model.addAttribute("title", "main");
		}
		List<NxSysMenu> menuList = menuServices.findAll();
		model.addAttribute("menus",menuList);
		return "kernel/index";
	}


	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
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


	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		NxUser user = new NxUser();
		model.addAttribute("user", user);
		return "newuser";
	}
	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public String getQueryPageByEnitty(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		String entityName = request.getParameter("entityClass");
		List<NxUser> result = userService.findAll();
		model.addAttribute("entityList",result);
		model.addAttribute("entity",NxUser.class.getName());
		return "kernel/entityList";
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String saveRegistration(@Valid NxUser user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		userService.save(user);

		System.out.println("First Name : "+user.getFirstName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("SSO ID : "+user.getSsoId());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Email : "+user.getEmail());
		System.out.println("Checking UsrProfiles....");
		if(user.getUserProfiles()!=null){
			for(NxUserProfile profile : user.getUserProfiles()){
				System.out.println("Profile : "+ profile.getType());
			}
		}
		model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
		return "registrationsuccess";
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
	
	@ModelAttribute("roles")
	public List<NxUserProfile> initializeProfiles() {
		System.out.println("#######initializeProfiles");
		return userProfileService.findAll();
	}
	
}
