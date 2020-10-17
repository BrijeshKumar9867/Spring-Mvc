package com.spring.service;

import java.util.List;

import com.spring.bean.EmployeeBean;

public interface EmployeeService {


	public List<EmployeeBean> userLogin(String username, String password);

	public List<EmployeeBean> getActiveUsers(String isActive);

}
