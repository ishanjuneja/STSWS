package com.yash.dao;

import java.util.List;

import com.yash.model.Course;
import com.yash.model.User;

public interface UserDAO {
	
	public int insertUser(User user);
	public List<Course> getCourses();
}
