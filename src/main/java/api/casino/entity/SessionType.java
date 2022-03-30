package api.casino.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="session_type")
public class SessionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int durationLimit = 60000;
	
	private int autoClose = 1;
	
	public SessionType() {
		// TODO Auto-generated constructor stub
	}

	public SessionType(int id, String name, int durationLimit, int autoClose) {
		super();
		this.id = id;
		this.name = name;
		this.durationLimit = durationLimit;
		this.autoClose = autoClose;
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

	public int getDurationLimit() {
		return durationLimit;
	}

	public void setDurationLimit(int durationLimit) {
		this.durationLimit = durationLimit;
	}

	public int getAutoClose() {
		return autoClose;
	}

	public void setAutoClose(int autoClose) {
		this.autoClose = autoClose;
	}
		
}
