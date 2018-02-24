package com.yash.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yash.model.Course;
import com.yash.model.Role;
import com.yash.model.User;
import com.yash.service.UserService;

public class UserTest {

	

	ApplicationContext ctx= new ClassPathXmlApplicationContext("resource/beans.xml");
	User user;
	@Before
	public void initialData(){
		user = new User();
		Course course = new Course();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter username");
		user.setUsername(sc.nextLine());	
		System.out.println("Enter Password");
		user.setPassword(sc.nextLine());		
		System.out.println("enter email");
		user.setEmail(sc.nextLine());
		System.out.println("enter course to be enrolled");
		course.setName(sc.nextLine());
		course.setId(1);
		course.setDuration(10);
		course.setStartdate(new Date());
		user.setCourse(course);
		Role role=new Role();
		role.setRoleid(1);
		role.setRole("trainee");
		user.setRole(role);
	}
	
	
	@Test
	public void insertTest() {	
		UserService service=ctx.getBean("userServiceImpl",UserService.class);
		int result=service.insertUser(user);
		assertEquals(1, result);
	}

}
