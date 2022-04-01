package api.casino.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.casino.HibernateConf;
import api.casino.entity.User;
import api.casino.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
		
	@GetMapping(path = "/users")
	public List<Object> retrieveAllUsers(){
		
		//return userService.findAll();
		
		
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManagerFactory" );		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
				
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
		*/
		
		
		SessionFactory sessionFactory = HibernateConf.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.getTransaction();
				
		try {
			txn.begin();
			
			//List<User> users = (List<User>) session.createNativeQuery("select user from User user");
			Query query = session.createQuery("select user, user.userType from User as user join user.userType");
			List<Object> users = query.getResultList();
			
						
			txn.commit();
			session.close();			
			
			return users;
		}catch(Exception e) {
			if(txn != null)txn.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		
		return null;
		
		
	}
}
