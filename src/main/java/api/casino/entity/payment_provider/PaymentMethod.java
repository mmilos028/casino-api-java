package api.casino.entity.payment_provider;

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
@Table(name="payment_method")
@JacksonXmlRootElement(localName = "PaymentMethod")
public class PaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="name")
	@JacksonXmlProperty(localName = "name")
	@JsonProperty(value = "name")
	private String name;
}
