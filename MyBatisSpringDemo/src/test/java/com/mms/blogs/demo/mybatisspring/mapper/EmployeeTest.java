package com.mms.blogs.demo.mybatisspring.mapper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mms.blogs.demo.mybatisspring.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class EmployeeTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Before
	public void insertEmployee(){
		Employee emp = new Employee();
		emp.setEmpid(1);
		emp.setFirstName("Manik");
		emp.setLastName("Magar");
		employeeMapper.insertEmployee(emp);
	}
	
	@Test
	public void testEmployee(){
		System.out.println("testEmployee");
		Employee emp = employeeMapper.getEmployeeName(1);
		Assert.assertNotNull(emp);
	}
	
}
