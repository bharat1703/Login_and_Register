package com.prasad.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.Dao.RegisterDao;
import com.prasad.Entity.RegisterUser;
import com.prasad.Model.Register;
import com.prasad.Service.RegisterService;
@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterDao registerDao;
	
	
	@Override
	public boolean addUser(Register register) {
		System.out.println("Hi i am from service impl"+register);
		RegisterUser ru=new RegisterUser();
		ru.setFirstName(register.getFirstName());
		ru.setLastName(register.getLastName());
		ru.setAge(register.getAge());
		ru.setEmail(register.getEmail());
		ru.setPassowrd(register.getPassword());
		System.out.println("Hi i am from service impl"+ru);
			
		boolean adduser=registerDao.addUser(ru);
		
	return true;
	}

	
	
	
	
}
