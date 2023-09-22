package api.casino.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import api.casino.util.LocalDateTimeDeserializer;
import api.casino.util.LocalDateTimeSerializer;

@Entity
@Table(name="user")
@JacksonXmlRootElement(localName = "User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 916382507342361472L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="username")
	@JacksonXmlProperty(localName = "username")
	private String username;
	
	@Column(name="email")
	@JacksonXmlProperty(localName = "email")
	private String email;
	
	@Column(name="password")
	@JsonIgnore
	private String password;
	
	@Column(name="first_name")
	@JacksonXmlProperty(localName = "first_name")
	@JsonProperty(value = "first_name")
	private String firstName;
	
	@Column(name="last_name")
	@JacksonXmlProperty(localName = "last_name")
	@JsonProperty(value = "last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="address")
	private String address;
	
	@Column(name="is_banned")
	@JacksonXmlProperty(localName = "is_banned")
	@JsonProperty(value = "is_banned")
	private String isBanned;
	
	@Column(name="verification_status")
	@JacksonXmlProperty(localName = "verification_status")
	@JsonProperty(value = "verification_status")
	private String verificationStatus;
	
	@Column(name="zip_code")
	@JacksonXmlProperty(localName = "zip_code")
	@JsonProperty(value = "zip_code")
	private String zipCode;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address2")
	private String address2;
	
	@JsonIgnore
	@Column(name="phone_number")
	@JacksonXmlProperty(localName = "phone_number")
	@JsonProperty(value = "phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@Column(name="bank_account_number")
	private String bankAccountNumber;
	
	//private int bankAccountCountry;
	
	@JsonIgnore
	@Column(name="bank_identification_code")
	private String bankIdentificationCode;
	
	@JsonIgnore
	@Column(name="international_bank_account_number")
	private String internationalBankAccountNumber;
	
	@Column(name="language")
	private String language;
	
	@Column(name="currency")
	private String currency;
	
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name="user_type_id")
	private UserType userType;
	
	@JsonIgnore
	@OneToMany(targetEntity = UserForUser.class, mappedBy = "userTo", fetch = FetchType.LAZY)
	private Set<User> userTo;
	
	/*
	@JsonIgnore
	@OneToMany(targetEntity = Session.class, fetch = FetchType.LAZY)
	private Set<Session> session;
	*/
				
	public User() {
		
	}

	public User(Long id, String username, String email, String password, String firstName, String lastName,
			String gender, Date birthdate, String address, String isBanned, String verificationStatus, String zipCode,
			String city, String address2, String phoneNumber, String bankAccountNumber, String bankIdentificationCode,
			String internationalBankAccountNumber, String language, String currency, UserType userType) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.isBanned = isBanned;
		this.verificationStatus = verificationStatus;
		this.zipCode = zipCode;
		this.city = city;
		this.address2 = address2;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber = bankAccountNumber;
		this.bankIdentificationCode = bankIdentificationCode;
		this.internationalBankAccountNumber = internationalBankAccountNumber;
		this.language = language;
		this.currency = currency;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsBanned() {
		return isBanned;
	}

	public void setIsBanned(String isBanned) {
		this.isBanned = isBanned;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIdentificationCode() {
		return bankIdentificationCode;
	}

	public void setBankIdentificationCode(String bankIdentificationCode) {
		this.bankIdentificationCode = bankIdentificationCode;
	}

	public String getInternationalBankAccountNumber() {
		return internationalBankAccountNumber;
	}

	public void setInternationalBankAccountNumber(String internationalBankAccountNumber) {
		this.internationalBankAccountNumber = internationalBankAccountNumber;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public Set<User> getUserTo() {
		return userTo;
	}
	
	public void setUserTo(Set<User> userTo) {
		this.userTo = userTo;
	}
	
	/*public Set<Session> getSession() {
		return session;
	}
	
	public void setSession(Set<Session> session) {
		this.session = session;
	}*/
	
	@Override
	public boolean equals(Object obj) {
		// 
		if(!User.class.isInstance(obj))return false;
		
		User user = (User)obj;
		
		return new EqualsBuilder()
				.append(id, user.id)
				.append(username, user.username)
				.append(email, user.email)
				.isEquals();	
	}

	@Override
	public int hashCode() {
		// 
		return new HashCodeBuilder()
				.append(id)
				.append(username)
				.append(email)
				.toHashCode();
	}
	
}
