package api.casino.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.casino.config.HibernateConf;
import api.casino.dao.UserDao;
import api.casino.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired(required = true)
	private SessionFactory hibernateSessionFactory;// = HibernateConf.getSessionFactory();
	
	@Override
	public Long addUser(User u) {
		Session session = this.hibernateSessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("User saved successfully, User Details={}", u);
		
		return u.getId();
	}

	@Override
	public User getUserById(int id) {
		Session session = this.hibernateSessionFactory.getCurrentSession();		
		User u = (User) session.load(User.class, Integer.valueOf(id));
		logger.info("User loaded successfully, User details={}", u);
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.hibernateSessionFactory.getCurrentSession();		
		List<User> usersList = session.createQuery("from User").list();
		for(User u : usersList){
			logger.info("Users List::{}", u);
		}
		return usersList;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.hibernateSessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, Integer.valueOf(id));
		if(null != u){
			session.delete(u);
		}
		logger.info("User deleted successfully, user details={}", u);
		
	}

	@Override
	public void updateUser(User u) {
		Session session = this.hibernateSessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User updated successfully, User Details={}", u);
	}
	

}
