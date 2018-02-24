package com.yash.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yash.dao.UserDAO;
import com.yash.model.Course;
import com.yash.model.User;
import com.yash.util.DBConnection;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private DBConnection DBConnection;
		
	
	public int insertUser(User user) {
		int result=0;
		String sql="insert into users(username,password,email,roleid,courseid) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=DBConnection.connect().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getRole().getRoleid());
			pstmt.setInt(5, user.getCourse().getId());
			 result= pstmt.executeUpdate();
			System.out.println("You have been registered");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Course> getCourses() {
		String sql="select * from courses";
		List<Course> courses = new ArrayList<Course>();
		Course course;
		try {
			PreparedStatement pstmt=DBConnection.connect().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				course=new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setDuration(rs.getInt("duration"));
				courses.add(course);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return courses;
	}

}
