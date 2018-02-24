package com.yash.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Option;
import com.yash.model.Question;
import com.yash.util.DBConnection;

@Repository
public class FeedbackDAOImpl {

	@Autowired
	private DBConnection DBConnection;
	
	public List<Question> getFeedbackQuestions(int technologyid){	
		String sql="select * from questions where courseid=?";
		List<Question> questions=new ArrayList<Question>();
		try {
			PreparedStatement pstmt=DBConnection.connect().prepareStatement(sql);
			pstmt.setInt(1, technologyid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Question question = new Question();
				question.setQuestion(rs.getString("question"));
				question.setId(rs.getInt("id"));
				question.setCourseid(rs.getInt("courseid"));
				questions.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}
	
	
	public List<Option> getFeedbackAnswers(int questionid){
		List<Option> options=new ArrayList<Option>();
		String sql="select * from options where questionid=?";
		try {
			PreparedStatement pstmt=DBConnection.connect().prepareStatement(sql);
			pstmt.setInt(1, questionid);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				Option option=new Option();
				option.setId(rs.getInt("id"));
				option.setOption(rs.getString("option"));
				option.setQuestionID(rs.getString("questionid"));
				options.add(option);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return options;
	}
	
	public int feedbackEntry(int questionid, int optionid, int userid){
		
		String sql="insert into feedback(questionid,optionid,userid) values(?,?,?)";
		try {
			PreparedStatement pstmt=DBConnection.connect().prepareStatement(sql);
			pstmt.setInt(1, questionid);
			pstmt.setInt(2, optionid);
			pstmt.setInt(3, userid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
}
