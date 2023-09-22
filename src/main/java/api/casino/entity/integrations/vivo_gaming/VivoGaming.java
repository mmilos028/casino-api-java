package api.casino.entity.integrations.vivo_gaming;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import api.casino.entity.User;

@Entity
@Table(name="vivo_gaming")
public class VivoGaming {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="token")
	@JacksonXmlProperty(localName = "token")
	@JsonProperty(value = "token")
	private String token;
	
	@Column(name="start_balance")
	@JacksonXmlProperty(localName = "start_balance")
	@JsonProperty(value = "start_balance")
	private Double startBalance;
	
	@Column(name="end_balance")
	@JacksonXmlProperty(localName = "end_balance")
	@JsonProperty(value = "end_balance")
	private Double endBalance;
	
	/* 1 - Opened, 2 - Closed */
	@Column(name="session_state")
	@JacksonXmlProperty(localName = "session_state")
	@JsonProperty(value = "session_state")
	private Integer sessionState;
	
	@Column(name="insert_date")
	@JacksonXmlProperty(localName = "insert_date")
	@JsonProperty(value = "insert_date")
	private Date insertDate;
}
