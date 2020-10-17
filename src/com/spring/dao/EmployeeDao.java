package com.spring.dao;

import java.util.List;

import com.spring.bean.EmployeeBean;

public interface EmployeeDao {

	public List<EmployeeBean> userLogin(String username,String password);

	public List<EmployeeBean> getActiveUsers(String isActive);

/*	void save(EmployeeBean employeeBean);*/

}
