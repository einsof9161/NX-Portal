package com.nx.kernel.controller;


import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nx.kernel.common.BeanValidators;

public abstract class NxBaseController {

	/**
	 * 日誌對象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 驗證Bean實例對象
	 */
	@Autowired
	protected Validator validator;

	/**
	 * 服務端參數有效性驗證
	 * @param object 驗證的實體對象
	 * @param groups 驗證組
	 * @return 驗證成功：返回true；嚴重失敗：將錯誤信息添加到 message 中
	 */
	protected boolean beanValidator(Model model, Object object, Class<?>... groups) {
		try{
			BeanValidators.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "數據驗證失敗：");
			addMessage(model, list.toArray(new String[]{}));
			return false;
		}
		return true;
	}
	
	
	/**
	 * 添加Model消息
	 * @param messages 消息
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}
	
	/**
	 * 添加Flash消息
     * @param messages 消息
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	
	
}

