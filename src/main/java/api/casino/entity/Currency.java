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
@Table(name="currency")
@JacksonXmlRootElement(localName = "Currency")
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	//ISO 4217 for example EUR, USD, RSD
	@Column(name="name")
	@JacksonXmlProperty(localName = "name")
	@JsonProperty(value = "name")
	private String name;
	
	//ISO 4217 for example EUR is 978
	@Column(name="code")
	@JacksonXmlProperty(localName = "code")
	@JsonProperty(value = "code")
	private String code;
	
	@Column(name="description")
	@JacksonXmlProperty(localName = "description")
	@JsonProperty(value = "description")
	private String description;
	
}
