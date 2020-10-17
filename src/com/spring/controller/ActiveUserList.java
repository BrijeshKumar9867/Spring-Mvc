package com.spring.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.bean.EmployeeBean;
import com.spring.service.EmployeeService;

@RestController
public class ActiveUserList {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/activeUsers/{isActive}", method = RequestMethod.GET,headers="Accept=application/json")
	@Produces({"application/json"})
	public List getActiveUser(@PathVariable String isActive) {
		System.out.println("Webservice call");
		List<EmployeeBean> activeUserList = employeeService.getActiveUsers(isActive);
		/*String username = "siddique";http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1139
		String password = "123";
		List<EmployeeBean>activeUserList = employeeService.userLogin(username, password);*/
		if(activeUserList.size() > 0) {
			return activeUserList;
		}
		return null;
		
	}
	
}
