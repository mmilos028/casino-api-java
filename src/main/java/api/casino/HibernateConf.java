package api.casino;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        //dataSource.setPassword("sa");

        return dataSource;
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
        jpaProperties.setProperty(
        		"hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty(
        		"hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return jpaProperties;
    }
    
    //private static final SessionFactory sessionFactory = buildSessionFactory();    
    
    private static SessionFactory buildSessionFactory() {
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
            settings.put("hibernate.hbm2ddl.auto", "create-drop"); //update
            settings.put("hibernate.ddl.auto", "create-drop"); //update
            
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