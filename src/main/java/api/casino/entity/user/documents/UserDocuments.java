package api.casino.entity.user.documents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import api.casino.entity.User;
import api.casino.util.LocalDateTimeDeserializer;
import api.casino.util.LocalDateTimeSerializer;

@Entity
@Table(name="user_documents")
@JacksonXmlRootElement(localName = "UserDocuments")
public class UserDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	
	@Column(name="upload_time")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private Date uploadTime = null;
	
	
	@Column(name="verification_status")
	private String verificationStatus = null;
	
	@Column(name="document_type")
	private String documentType = null;
	
	@Column(name="verification_time")
	private Date verificationTime = null;
	
	@ManyToOne(targetEntity = User.class)
	private User verifiedByUser;
	
	public UserDocuments() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDocuments(int id, User user, Date uploadTime, String verificationStatus, 
			String documentType, Date verificationTime, User verifiedByUser) {
		this.id = id;
		this.uploadTime = uploadTime;
		this.verificationStatus = verificationStatus;
		this.documentType = documentType;
		this.verificationTime = verificationTime;
		this.verifiedByUser = verifiedByUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Date getVerificationTime() {
		return verificationTime;
	}

	public void setVerificationTime(Date verificationTime) {
		this.verificationTime = verificationTime;
	}

	public User getVerifiedByUser() {
		return verifiedByUser;
	}

	public void setVerifiedByUser(User verifiedByUser) {
		this.verifiedByUser = verifiedByUser;
	}
	
}
