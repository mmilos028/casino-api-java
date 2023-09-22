package api.casino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="games")
@JacksonXmlRootElement(localName = "Game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="name")
	@JacksonXmlProperty(localName = "name")
	@JsonProperty(value = "name")
	private String name;
	
	//E - Enabled, D - Disabled
	@Column(name="status")
	@JacksonXmlProperty(localName = "status")
	@JsonProperty(value = "status")
	private String status;
	
	@Column(name="comment")
	@JacksonXmlProperty(localName = "comment")
	@JsonProperty(value = "comment")
	private String comment;

}
