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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.NxUser;
import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.service.NxSysMenuService;
import com.nx.kernel.service.NxUserProfileService;
import com.nx.kernel.service.NxUserService;

//@Controller
public class NxUserManagerController {

}
