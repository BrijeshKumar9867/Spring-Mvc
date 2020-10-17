package com.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name="empname")
	private String empName;
	
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="isactive")
	private String isActve;
	
	public String getIsActve() {
		return isActve;
	}

	public void setIsActve(String isActve) {
		this.isActve = isActve;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", username=" + username + ", password=" + password + "]";
	}*/


}


