package com.prasad.Dao.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.Dao.UserDao;
import com.prasad.Entity.RegisterUser;
import com.prasad.Model.User;
@Service("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User loginUser(User user) {
		System.out.println("hi i am from dao impl"+user);
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<RegisterUser> criteriaQuery = builder.createQuery(RegisterUser.class);
			Root<RegisterUser> root = criteriaQuery.from(RegisterUser.class);
			criteriaQuery.select(root);
			Query query = session.createQuery(criteriaQuery);
			List<RegisterUser> list = query.getResultList();
			for (RegisterUser user2 : list) {
				if(user2.getEmail().equals(user.getEmail()) && user2.getPassowrd().equals(user.getPassword())) {
					return user;
				}
			}
			tx.commit();
		}catch (HibernateException he) {
			he.printStackTrace();
			if(tx.getStatus() != null) {
				tx.rollback();
			}
		}

	return null;
	}

}
