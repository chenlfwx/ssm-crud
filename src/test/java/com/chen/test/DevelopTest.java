package com.chen.test;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DevelopTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmployeeMapper employeeMapper;
	@Test
	public void testDataSource() throws SQLException {
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testSave() throws Exception {
		
		for (int i = 0; i < 1000; i++) {
			String name = UUID.randomUUID().toString().substring(2, 6);
			Employee e = new Employee(i, name, "0", name + "@qq.com", 1);
			employeeMapper.insert(e);
		}
	}
}
