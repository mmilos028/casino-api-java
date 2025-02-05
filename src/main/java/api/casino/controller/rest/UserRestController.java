package api.casino.controller.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import api.casino.config.HibernateConf;
import api.casino.controller.rest.exception.ResourceNotFoundException;
import api.casino.entity.User;
import api.casino.model.Users;
import api.casino.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SessionFactory sessionFactory;
			
	@GetMapping(path = "/users")
	public Users retrieveAllUsers() throws ResourceNotFoundException {

		//return userService.findAll();

		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManagerFactory" );		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
				
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
		*/

		//SessionFactory sessionFactory = HibernateConf.getSessionFactory();
		//SessionFactory sessionFactory = HibernateConf.buildSessionFactoryConfig();
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
				
		throw new ResourceNotFoundException("Users not found");		
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		
		/*
		User user = userService.findById(id)
		.stream()
		.findFirst()
		.orElse(null);
		
		if(user == null) {
			throw new ResourceNotFoundException("User not found");
		}else {
			return user;
		}
		*/
		String message = "User not found";
		
		return userService.findById(id)
		.stream()
		.findFirst()		
		.orElseThrow(() -> new ResourceNotFoundException(message))
		;
	}
	
	/*
	@GetMapping(path = "/pdf")
	public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String text = "Some text for example";
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    
	    PdfWriter pdfWriter = new PdfWriter(baos);

        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
        
        PdfPage pdfPage = pdfDoc.addNewPage();
        
                
        pdfDoc.setDefaultPageSize(PageSize.A4);
        
        Document doc = new Document(pdfDoc);        
        doc.setMargins(10, 10, 10, 10);
        
                                
        //doc.add(new Paragraph("You have submitted the following text:"));
        //doc.add(new Paragraph(text));
        //doc.close();
                       
        
       
        PdfCanvas canvas = new PdfCanvas(pdfPage);
        // Initial point of the line  
        canvas.moveTo(100, 300);
        canvas.setStrokeColor(Color.RED);
        // Drawing the line
        canvas.lineTo(500, 300);
        // Closing the path stroke       
        canvas.closePathStroke();
        
        canvas
        .beginText()
        .setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
        .moveText(110, 310)
        .showText("PRIMER1")
        .endText()
        .beginText()
        .setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
        .moveText(110, 410)
        .showText("PRIMER2")
        .endText()
        .beginText()
        .setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
        .moveText(110, 810)
        .showText("PRIMER3")
        .endText();
        
        doc.close();
        
	    return ResponseEntity.ok()
	    		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf") 
                .contentType(MediaType.APPLICATION_PDF) 
                .body(baos.toByteArray());   

	}*/

}
