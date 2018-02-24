package com.yash.service;

import java.util.List;

import com.yash.model.Course;
import com.yash.model.User;

public interface UserService {

	public int insertUser(User user);
	public List<Course> getCourses();
}
