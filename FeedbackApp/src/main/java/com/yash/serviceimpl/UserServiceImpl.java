package com.yash.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.UserDAO;
import com.yash.model.Course;
import com.yash.model.User;
import com.yash.service.UserService;
import com.yash.util.EncryptDecrypt;
import com.yash.util.SendEmail;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	

	public UserDAO getUserDAO() {
		return userDAO;
	}

	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public int insertUser(User user) {
		int result=userDAO.insertUser(user);
		
		try {
			EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
			String link="http://10.15.10.15:8080/APPNAME/CONTROLLER?"+encryptDecrypt.encrypt(user.getEmail()+user.getCourse().getName());
			
			SendEmail email=new SendEmail();
			email.sendMail(user.getEmail(),link);
		} catch (UnsupportedEncodingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<Course> getCourses() {
		
		return userDAO.getCourses();
	}

	
}
