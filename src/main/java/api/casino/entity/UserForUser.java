package api.casino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="user_for_user")
public class UserForUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = true)
	private String userToName = "";
	
	@Column(nullable = true)
	private String userForName = "";
	
	//@NaturalId
	@JsonIgnore
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	private User userTo;
	
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	private User userFor;
	
	public UserForUser() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserTo() {
		return userTo;
	}
	
	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}

	public User getUserFor() {
		return userFor;
	}

	public void setUserFor(User userFor) {
		this.userFor = userFor;
	}
	
	public String getUserToName() {
		return userToName;
	}

	public void setUserToName(String userToName) {
		this.userToName = userToName;
	}

	public String getUserForName() {
		return userForName;
	}

	public void setUserForName(String userForName) {
		this.userForName = userForName;
	}

	@Override
	public String toString() {
		return "UserForUser [id=" + id + ", userTo=" + userTo + ", userFor=" + userFor + "]";
	}
	
}
