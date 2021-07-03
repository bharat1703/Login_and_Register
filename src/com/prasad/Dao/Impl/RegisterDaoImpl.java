package com.prasad.Dao.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.Dao.RegisterDao;
import com.prasad.Entity.RegisterUser;
@Service("registerDao")
public class RegisterDaoImpl implements RegisterDao{

	@Autowired
	private SessionFactory sessoFactory;
	
	@Override
	public boolean addUser(RegisterUser ru) {
		System.out.println("hi i am from dao impl"+ru);
		Session session = sessoFactory.openSession();
		Transaction tx = null;
		boolean transactionStatus = true;
		try {
			tx = session.beginTransaction();
			session.save(ru);
			tx.commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx.getStatus() != null) {
				tx.rollback();
				transactionStatus = false;
			}
		}finally {
			session.close();
		}
		System.out.println("End of RegsiterDaoImpl "+transactionStatus);
		return transactionStatus;
	}

	}

	
	
	
	

