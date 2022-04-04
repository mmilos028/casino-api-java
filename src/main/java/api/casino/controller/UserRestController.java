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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import api.casino.HibernateConf;
import api.casino.entity.User;
import api.casino.model.Users;
import api.casino.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
			
	@GetMapping(path = "/users")
	public Users retrieveAllUsers(){
		
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
			//Query query = session.createQuery("select user, user.userType from User as user join user.userType");
			Query query = session.createQuery("select user from User as user");
			
			
			//List<Object> users = query.getResultList();
			List<User> users = query.getResultList();
			
			Users usersOutput = new Users();
			usersOutput.setUsers(users);
			
						
			txn.commit();
			session.close();			
			
			return usersOutput;
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
