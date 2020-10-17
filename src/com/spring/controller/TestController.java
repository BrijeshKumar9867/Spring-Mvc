package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.CommonBean;
import com.spring.bean.EmployeeBean;
import com.spring.service.EmployeeService;

@Controller
public class TestController {
	private static final Logger LOGGER = LogManager.getLogger(TestController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CommonBean commonBean;


	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result, Model model) {
		LOGGER.error("inside addEmployee()", "TestController");
		List<EmployeeBean> empList = employeeService.userLogin(employeeBean.getUsername(), employeeBean.getPassword());

		LOGGER.info("value of CommonBean::" + commonBean.getUsername());
		if (empList.size() > 0) {
			for (EmployeeBean em : empList) {
				commonBean.setUsername(em.getUsername());
				model.addAttribute("employees", commonBean);
			}
			return "home";
		} else {
			return "index";
		}

	}
*/

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("command") EmployeeBean employeeBean,BindingResult result, Model model,HttpServletRequest request, HttpServletResponse response) {
		LOGGER.error("inside addEmployee()", "TestController");
		if(employeeBean.getUsername() !=null) {
		commonBean.setUsername(employeeBean.getUsername());
		commonBean.setPassword(employeeBean.getPassword());
		}
		List<EmployeeBean>empList = employeeService.userLogin(commonBean.getUsername(), commonBean.getPassword());
		LOGGER.info("value of CommonBean::" + commonBean.getUsername());
		if (empList.size() > 0) {
			for (EmployeeBean em : empList) {
				HttpSession session = request.getSession();
			//	session.setAttribute("name", em.getUsername());
				session.setAttribute("name", commonBean.getUsername());
			}
			return "home";
		} else {
			return "index";
		}

	}
	
	
	
	/*@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("inside logoutmethod", "TestController");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}*/

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        System.out.println("logout()");
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/login?logout";
    }
	
}
