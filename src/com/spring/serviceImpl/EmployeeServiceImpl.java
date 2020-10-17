package com.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.EmployeeBean;
import com.spring.dao.EmployeeDao;
import com.spring.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	@Override
	public List<EmployeeBean> userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return employeeDao.userLogin(username, password);
	}

	@Transactional
	@Override
	public List<EmployeeBean> getActiveUsers(String isActive) {
		// TODO Auto-generated method stub
		return employeeDao.getActiveUsers(isActive);
	}

	
	
	
	
	
	

	/*@Transactional
	@Override
	public void save(EmployeeBean employeeBean) {
		
		employeeDao.save(employeeBean);
		
	}*/

}
