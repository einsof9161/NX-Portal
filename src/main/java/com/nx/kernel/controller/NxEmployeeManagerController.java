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

import com.nx.kernel.model.NxImageFile;
import com.nx.kernel.model.NxPageView;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.service.NxEmployeeService;
import com.nx.kernel.service.NxImageFileService;

/**
 * @author edward
 *
 */
@Controller
public class NxEmployeeManagerController {
	
	@Autowired
	NxEmployeeService<NxEmployee> employeeService;

	@Autowired
	NxImageFileService<NxImageFile> imageServices;
	
	@RequestMapping(value = { "/employee/list"}, method = RequestMethod.GET)
	public String getEmplist(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		NxPageView<NxEmployee> pageView = new NxPageView<NxEmployee>(12, 1);
		pageView.setRecords(employeeService.findAll());
		
		/*if("true".equals(model.get("query"))){
			StringBuilder jpql = new StringBuilder();
			List<Object> params = new ArrayList<Object>();
			if(model.get("userName")!=null){
				params.add("%"+ model.get("userName")+"%");
				jpql.append("o.username like ?").append(params.size());
			}
			pageView.setQueryResult(
					employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
							jpql.toString(), params.toArray(), orderby));
		}else{
			pageView.setQueryResult(employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), orderby));
		}*/	
		model.put("history", "/employee/list");
		model.put("pageView", pageView);
		return "employee/list";
	}

	@RequestMapping(value = { "/employee/manage/edit"}, method = RequestMethod.GET)
	public String edit(ModelMap model,@RequestParam String method ,@RequestParam int id) {
		NxEmployee emp = employeeService.find(id);
		System.out.println("Edit:"+emp);
		model.put("entity",emp);
		model.put("empEdit",emp);
		return "employee/createEmp";
	}
	 
	@RequestMapping(value = { "/employee/manage/save"}, method = RequestMethod.POST)
	public String save(@ModelAttribute("empEdit") NxEmployee empEdit,ModelMap model,BindingResult result) {
		if(empEdit.getImage().getId()!=null){
			NxImageFile image = imageServices.findById(empEdit.getImage().getId());
			empEdit.setImage(image);
			employeeService.merge(empEdit);
		}else{
			empEdit.setImage(null);
			employeeService.save(empEdit);
		}
		return "redirect:/employee/list";
	}
}
