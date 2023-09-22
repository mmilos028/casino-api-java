package api.casino.entity.fee_system;

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
@Table(name="fee_type")
@JacksonXmlRootElement(localName = "FeeType")
public class FeeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
		
	@Column(name="name")
	@JacksonXmlProperty(localName = "name")
	@JsonProperty(value = "name")
	private String name;
	
	//This is status of each fee type. If Cancelled in this table it should not be in use in child tables for new records.
	//Possible statuses for now:Active, Cancelled
	@Column(name="status")
	@JacksonXmlProperty(localName = "status")
	@JsonProperty(value = "status")
	private String status;
	
	/**
	 * Type description
	 */
	@Column(name="description")
	@JacksonXmlProperty(localName = "description")
	@JsonProperty(value = "description")
	private String description;
	
	/**
	 * short type name without _fee
	 */
	@Column(name="short_name")
	@JacksonXmlProperty(localName = "short_name")
	@JsonProperty(value = "short_name")
	private String shortName;
}
