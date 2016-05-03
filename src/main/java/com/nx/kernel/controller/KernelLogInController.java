package com.nx.kernel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nx.kernel.model.NxUser;
import com.nx.kernel.service.NxUserServices;

@Controller
@RequestMapping("/KernelServer") 
public class KernelLogInController {
	
	@Autowired
	@Qualifier("nxUsrServices")
	private NxUserServices userServices;

	boolean LOG_IN_SUCESS =true;
	private static int i=0;
	/**
	 * 首頁,判斷是否已經登入過
	 * 登入過->跳轉至系統畫面
	 * 未登入->跳轉至登入畫面
	 * 
	 * **/
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("###"+i);
		if(LOG_IN_SUCESS ){
			return "redirect:"+"/KernelServer/index";
		}
		// 登录成功后，验证码计算器清零
		//isValidateCodeLogin(user.getLoginName(), false, true);
		//UserUtils.putCache("siteId", CookieUtils.getCookie(request, "siteId"));
		return "kernel/login";
	}
	
	/**
	 * 登入成功,跳轉至系統畫面
	 * **/
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "kernel/index";
	}
	
	/**
	 * 尚未登入,跳轉至登入畫面
	 * **/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "kernel/login";
	}
	
	@RequestMapping(value = "/starter", method = RequestMethod.GET)
	public String starter(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "kernel/starter";
	}
	
	@RequestMapping(value = "/userManager", method = RequestMethod.GET)
	public String userManager(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "kernel/userManager";
	}
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute NxUser userInfo,HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("######"+model.asMap());
		System.out.println(userInfo.getAccount());
		System.out.println(userInfo.getPwd());
		NxUser user = userServices.validateUser(userInfo.getAccount());
		System.out.println(user.getEntityId());
		request.setAttribute("LOG_IN_FAIL", "please check your accotun or password!");
		return "redirect:"+"/KernelServer/";
	}
	
}
