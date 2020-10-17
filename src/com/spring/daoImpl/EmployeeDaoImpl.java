package com.spring.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.CommonBean;
import com.spring.bean.EmployeeBean;
import com.spring.dao.EmployeeDao;
import com.spring.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CommonBean commonBean;

	@Override
	public List<EmployeeBean> userLogin(String username, String password) {
		List<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeBean = new EmployeeBean();
		List<EmployeeEntity> employeeEntities= sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where username = :username and password = :password",EmployeeEntity.class).setParameter("username", username).setParameter("password", password).getResultList();
		for(EmployeeEntity employeeEntity : employeeEntities) {
			employeeBean.setId(employeeEntity.getEmpId());
			employeeBean.setName(employeeEntity.getEmpName());
			employeeBean.setUsername(employeeEntity.getUsername());
			commonBean.setUsername(employeeEntity.getEmpName());
			empBeanList.add(employeeBean);
		}
		return empBeanList;
	}

	@Override
	public List<EmployeeBean> getActiveUsers(String isActive) {
		List<EmployeeBean> activeUsersList = new ArrayList<EmployeeBean>();
		List<EmployeeEntity> employeeEntities = new ArrayList<>();
		EmployeeBean employeeBean = new EmployeeBean();
		//List<EmployeeEntity> employeeEntities = sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where isActive = :isActive", EmployeeEntity.class).setParameter("isActive", isActive).getResultList();
	//	List<EmployeeEntity> employeeEntities= sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where username = :username and password = :password",EmployeeEntity.class).setParameter("username", "siddique").setParameter("password", "123").getResultList();
		try {
		//employeeEntities = sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").getResultList();
			//employeeEntities= sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where username = :username and password = :password",EmployeeEntity.class).setParameter("username", "sddique").setParameter("password", "123").getResultList();
			employeeEntities = sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where isActive = :isActive", EmployeeEntity.class).setParameter("isActive", isActive).getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		for(EmployeeEntity employeeEntity : employeeEntities) {
			employeeBean.setId(employeeEntity.getEmpId());
			employeeBean.setName(employeeEntity.getEmpName());
			employeeBean.setUsername(employeeEntity.getUsername());
			employeeBean.setIsActive(employeeEntity.getIsActve());;
			activeUsersList.add(employeeBean);
		}
		return activeUsersList;
	}	}
	
