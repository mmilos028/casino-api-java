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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="UserType")
@Table(name="user_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(name="is_super_type")
	private int isSuperType = 0;
	
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name="parent_user_type_id")
	private UserType parentUserType = null;
	
	public UserType() {
		
	}
	
	public UserType(int id, String name, int isSuperType, UserType parentUserType) {
		super();
		this.id = id;
		this.name = name;
		this.isSuperType = isSuperType;
		this.parentUserType = parentUserType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsSuperType() {
		return isSuperType;
	}
	public void setIsSuperType(int isSuperType) {
		this.isSuperType = isSuperType;
	}
	public UserType getParentUserType() {
		return parentUserType;
	}
	public void setParentUserType(UserType parentUserType) {
		this.parentUserType = parentUserType;
	}
	@Override
	public String toString() {
		return "UserType [id=" + id + ", name=" + name + ", isSuperType=" + isSuperType + ", parentUserType="
				+ parentUserType + "]";
	}
	
}
