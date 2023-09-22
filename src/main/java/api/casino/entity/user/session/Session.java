package api.casino.entity.user.session;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import api.casino.entity.User;
import api.casino.util.LocalDateTimeDeserializer;
import api.casino.util.LocalDateTimeSerializer;

@Entity
@Table(name="session")
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private Date endDate = null;
	
	private Double credits;
	
	private String currency;
	
	@Column(name="session_state")
	private String sessionState = null;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="session_token")
	private String sessionToken = null;
	
	@Column(name="user_agent")
	private String userAgent;
		
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;	
	
	@ManyToOne(targetEntity = SessionType.class, fetch = FetchType.EAGER)
	@JoinColumn(name="session_type_id")
	private SessionType sessionType;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getCredits() {
		return credits;
	}

	public void setCredits(Double credits) {
		this.credits = credits;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSessionState() {
		return sessionState;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SessionType getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 
		if(!Session.class.isInstance(obj))return false;
		
		Session session = (Session)obj;
		
		return new EqualsBuilder()
				.append(id, session.id)
				.append(currency, session.currency)
				.isEquals();	
	}

	@Override
	public int hashCode() {
		// 
		return new HashCodeBuilder()
				.append(id)
				.append(currency)
				.toHashCode();
	}

}
