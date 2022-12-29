package api.casino.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import api.casino.entity.User;
import api.casino.entity.UserForUser;
import api.casino.entity.UserType;

@Configuration
@EnableTransactionManagement
public class HibernateConf {
	
	@Autowired
    private Environment env;
		
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean jpaSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
          "api.casino.entity"
        );
        sessionFactory.setHibernateProperties(jpaProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        //dataSource.setPassword("sa");

        return dataSource;
    }
    
    @Bean(name = "hibernateSessionFactory")
    public SessionFactory hibernateSessionFactory() {
    	try {
            
            Map<String, String> settings = new HashMap<>();
            settings.put("hibernate.connection.driver_class", "org.h2.Driver");
            settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("hibernate.connection.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("jpa.defer-datasource-initialization", "true");
            settings.put("hibernate.connection.url", "jdbc:h2:mem:testdb");
            settings.put("hibernate.connection.username", "sa");
            settings.put("hibernate.connection.password", "");
            settings.put("hibernate.connection.autocommit", "true");
            settings.put("hibernate.current_session_context_class", "thread");
            settings.put("hibernate.show_sql", "true");
            settings.put("hibernate.format_sql", "true");
            
            settings.put("hibernate.hbm2ddl.auto", "create-drop"); //update / create-drop
            settings.put("hibernate.ddl-auto", "create-drop"); //update / create-drop
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            		.applySettings(settings)
            		//.configure("hibernate.cfg.xml")
            		.build();
            Metadata metadata = new MetadataSources(serviceRegistry)     		
            		.addAnnotatedClass(User.class)
            		.addAnnotatedClass(UserType.class)
            		.addAnnotatedClass(UserForUser.class)
            		
            		.getMetadataBuilder()
            		.build();
            return metadata            		
            		.getSessionFactoryBuilder()
            		.build();            
            
        }
        catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            //System.err.println("Initial SessionFactory creation failed." + ex);
            //throw new ExceptionInInitializerError(ex);
        	ex.printStackTrace();
        	
        	return null;
        }
    }

    /*
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
               
        return transactionManager;
    }*/

	
    private final Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        
        jpaProperties.setProperty("jpa.defer-datasource-initialization", "true");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop"); //update or create-drop
        jpaProperties.setProperty(
        		"hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return jpaProperties;
    }
    
    //private static final SessionFactory sessionFactory = buildSessionFactory();    
    
    //from hibernate.cfg
    public static SessionFactory buildSessionFactoryConfig() {
	  // SessionFactory in Hibernate 5 example
	  org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
	  config.configure();
	  // local SessionFactory bean created
	  SessionFactory sessionFactory = config.buildSessionFactory();
	  //org.hibernate.Session session = sessionFactory.getCurrentSession();
	  //return session;
	  return sessionFactory;
    }
    
    //from method's java code
    private static SessionFactory buildSessionFactory() {
        try {
            
            Map<String, String> settings = new HashMap<>();
            settings.put("hibernate.connection.driver_class", "org.h2.Driver");
            settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("hibernate.connection.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("jpa.defer-datasource-initialization", "true");
            settings.put("hibernate.connection.url", "jdbc:h2:mem:testdb");
            settings.put("hibernate.connection.username", "sa");
            settings.put("hibernate.connection.password", "");
            settings.put("hibernate.connection.autocommit", "true");
            settings.put("hibernate.current_session_context_class", "thread");
            settings.put("hibernate.show_sql", "true");
            settings.put("hibernate.format_sql", "true");
            
            settings.put("hibernate.hbm2ddl.auto", "create-drop"); //update / create-drop
            settings.put("hibernate.ddl-auto", "create-drop"); //update / create-drop
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            		.applySettings(settings)
            		//.configure("hibernate.cfg.xml")
            		.build();
            Metadata metadata = new MetadataSources(serviceRegistry)     		
            		.addAnnotatedClass(User.class)
            		.addAnnotatedClass(UserType.class)
            		.addAnnotatedClass(UserForUser.class)
            		
            		.getMetadataBuilder()
            		.build();
            return metadata            		
            		.getSessionFactoryBuilder()
            		.build();            
            
        }
        catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            //System.err.println("Initial SessionFactory creation failed." + ex);
            //throw new ExceptionInInitializerError(ex);
        	ex.printStackTrace();
        	
        	return null;
        }
    }
    
    /*public SessionFactory sessionFactory() {
        try {
                        
            Map<String, String> settings = new HashMap<>();
            settings.put("hibernate.connection.driver_class", "org.h2.Driver");
            settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("hibernate.connection.dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("dialect", "org.hibernate.dialect.H2Dialect");
            settings.put("hibernate.connection.url", "jdbc:h2:mem:testdb");
            settings.put("hibernate.connection.username", "sa");
            settings.put("hibernate.connection.password", "");            
            settings.put("hibernate.current_session_context_class", "thread");
            settings.put("hibernate.show_sql", "true");
            settings.put("hibernate.format_sql", "true");
            settings.put("hibernate.hbm2ddl.auto", "update");

            
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            		.applySettings(settings)
            		//.configure("hibernate.cfg.xml")
            		.build();
            Metadata metadata = new MetadataSources(serviceRegistry)
            		.addAnnotatedClass(User.class)
            		.addAnnotatedClass(UserType.class)
            		.addAnnotatedClass(UserForUser.class)
            		//.addResource("api.casino.entity")
            		.getMetadataBuilder()
            		.build();
            return metadata
            		.getSessionFactoryBuilder()
            		.build();            
            
        }
        catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            //System.err.println("Initial SessionFactory creation failed." + ex);
            //throw new ExceptionInInitializerError(ex);
        	ex.printStackTrace();
        	
        	return null;
        }
    }*/
    
    
    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }
}