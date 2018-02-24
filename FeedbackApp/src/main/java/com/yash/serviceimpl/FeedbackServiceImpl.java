package com.yash.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.daoimpl.FeedbackDAOImpl;
import com.yash.model.Option;
import com.yash.model.Question;
import com.yash.model.User;
import com.yash.util.EncryptDecrypt;

@Service
public class FeedbackServiceImpl {

	@Autowired
	FeedbackDAOImpl feedbackDAOImpl;
	
	
	public String decryptLink(String link){
		String result = null;
		try {
			EncryptDecrypt encryptDecrypt=new EncryptDecrypt();
			result=encryptDecrypt.decrypt(link);			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Question> feedbackQuestionDisplay(String course){
		
		//TODO call a method to calculate courseid from course
		
		List<Question> questions= new ArrayList<Question>();
		questions=feedbackDAOImpl.getFeedbackQuestions(2);
		for (Question question : questions) {
			System.out.println(question.getQuestion());
		}
		return questions;
	}
	
	public void feedbackDisplay(String result){
		//TODO call a method to calculate course name from decrypted result and email from decrypted result
		//TODO call a method to get userid from email to be entered in database
		
		Scanner sc=new Scanner(System.in);
			User user = new User();
			user.setId(13);
			user.setUsername("mayank");
		List<Question> questions = feedbackQuestionDisplay("spring");
		for (Question question : questions) {
			int questionid=question.getId();
			List<Option> options=new ArrayList<Option>();
			options=feedbackDAOImpl.getFeedbackAnswers(questionid);
			System.out.println("------"+question.getQuestion()+"-------");
			for (Option option : options) {
				System.out.println(option.getOption());
			}
			System.out.println("choose your option :");
			String optiontext=sc.nextLine();
			Option option=new Option();
			for (Option temp : options) {
				if(optiontext.equals(temp.getOption())) 
				{
					option=temp;
					feedbackEntry(question,option,user);
				}
				else{
					System.out.println("no matching option");
				}
			}
			
		}
		
	}
	
	
	public void feedbackEntry(Question question,Option option,User user){
		feedbackDAOImpl.feedbackEntry(question.getId(),option.getId(),user.getId());
	}
	
	
}
