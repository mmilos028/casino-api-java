package api.casino.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="user_for_user")
public class UserForUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//@ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	//@JoinColumn(name="user_to_id")
	//@Column(name = "user_to_id")
	@OneToOne(mappedBy="user_to")
	private int userTo = 0;
	
	//@ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Column(name = "user_for_id")
	private int userFor = 0;
	
	public UserForUser() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserTo() {
		return userTo;
	}

	public void setUserTo(int userTo) {
		this.userTo = userTo;
	}

	public int getUserFor() {
		return userFor;
	}

	public void setUserFor(int userFor) {
		this.userFor = userFor;
	}

	@Override
	public String toString() {
		return "UserForUser [id=" + id + ", userTo=" + userTo + ", userFor=" + userFor + "]";
	}
	
}
