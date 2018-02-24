package com.yash.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yash.serviceimpl.FeedbackServiceImpl;
import com.yash.util.EncryptDecrypt;

public class FeedbackTest {

	ApplicationContext ctx= new ClassPathXmlApplicationContext("resource/beans.xml");
	
	@Test
	public void decryptTest() {
		String link="Q8petXJnz6HVqcWJYQRHAHsKmbs6VYJe6n59WmTXwTI=";
		FeedbackServiceImpl fImpl=ctx.getBean("feedbackServiceImpl",FeedbackServiceImpl.class);
		String result=fImpl.decryptLink(link);
		System.out.println(result);
		assertEquals("mayank@yash.comspring", result);
	}

	@Test
	public void feedbackQuestionsDisplayTest(){
		String feedbackshow="mayank@yash.comspring";
		FeedbackServiceImpl fImpl=ctx.getBean("feedbackServiceImpl",FeedbackServiceImpl.class);
		fImpl.feedbackQuestionDisplay(feedbackshow);
	}
	
	@Test
	public void feedbackAnswersDisplayTest(){
		String feedbackshow="mayank@yash.comspring";
		FeedbackServiceImpl fImpl=ctx.getBean("feedbackServiceImpl",FeedbackServiceImpl.class);
		fImpl.feedbackDisplay(feedbackshow);
	}
	
	
	
}
