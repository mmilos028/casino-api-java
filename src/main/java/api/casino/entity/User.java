package api.casino.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthdate;
	private String address;
	private String isBanned;
	private String verificationStatus;
	private String zipCode;
	private String city;
	private String address2;
	private String phoneNumber;
	private String bankAccountNumber;
	//private int bankAccountCountry;
	private String bankIdentificationCode;	
	private String internationalBankAccountNumber;
	private String language;
	private String currency;
	
	//private int userType;	
	
	public User() {
		
	}

	public User(int id, String username, String email, String password, String firstName, String lastName,
			String gender, Date birthdate, String address, String isBanned, String verificationStatus, String zipCode,
			String city, String address2, String phoneNumber, String bankAccountNumber, String bankIdentificationCode,
			String internationalBankAccountNumber, String language, String currency) {
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
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
}
