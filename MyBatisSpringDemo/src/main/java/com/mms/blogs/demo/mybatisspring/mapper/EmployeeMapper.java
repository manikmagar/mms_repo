package com.mms.blogs.demo.mybatisspring.mapper;

import com.mms.blogs.demo.mybatisspring.vo.Employee;

public interface EmployeeMapper {

	public Employee getEmployeeName(long empId);
	
	public void insertEmployee(Employee employee);
	
	
}
