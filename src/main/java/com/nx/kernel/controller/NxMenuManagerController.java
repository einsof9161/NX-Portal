/**
 * 
 */
package com.nx.kernel.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nx.kernel.model.NxPageView;
import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.service.NxSysMenuService;

/**
 * @author edward
 *
 */
@Controller
public class NxMenuManagerController {
	
	@Autowired
	NxSysMenuService<NxSysMenu> sysmenuService;

	@RequestMapping(value = { "/menu/list"}, method = RequestMethod.GET)
	public String getlist(ModelMap model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		NxPageView<NxSysMenu> pageView = new NxPageView<NxSysMenu>(12, 1);
		pageView.setRecords(sysmenuService.findParentMenu());
		model.put("pageView", pageView);
		model.put("isParent", true);
		
		return "system_menu/list";
	}
	
	@RequestMapping(value = { "/menu/list/sub"}, method = RequestMethod.GET)
	public String getSublist(ModelMap model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		NxPageView<NxSysMenu> pageView = new NxPageView<NxSysMenu>(12, 1);
		pageView.setRecords(sysmenuService.findChildMenu());
		model.put("pageView", pageView);
		model.put("isParent", false);
		return "system_menu/sublist";
	}
	
	@RequestMapping(value = { "/menu/manage/edit"}, method = RequestMethod.GET)
	public String edit(ModelMap model,@RequestParam String method ,@RequestParam int id,@RequestParam boolean isParent) {
		System.out.println("id:"+id);
		System.out.println("method:"+method);
		NxSysMenu menu = sysmenuService.findById(id);
		
		model.put("menuEdit",menu);
		model.put("isParent", isParent);
		return "system_menu/update";
	}
	
	@RequestMapping(value = { "/menu/manage/save"}, method = RequestMethod.POST)
	public String save(@ModelAttribute("menuEdit") NxSysMenu menuEdit,@RequestParam(required=true) boolean isParent,ModelMap model,BindingResult result) {
		System.out.println("NxEmployee######"+menuEdit);
		System.out.println("isParent######"+isParent);
		if(!isParent){
			NxSysMenu parent = sysmenuService.findById(menuEdit.getParent().getId());
			menuEdit.setParent(parent);
			System.out.println("menuEdit.setParent######"+menuEdit.getParent());
		}
		sysmenuService.save(menuEdit);
		model.put("message",200);
		return "system_menu/update";
	}
}
