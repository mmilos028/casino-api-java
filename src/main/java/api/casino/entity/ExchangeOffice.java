package api.casino.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="exchange_office")
@JacksonXmlRootElement(localName = "ExchangeOffice")
public class ExchangeOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@ManyToOne(targetEntity = Currency.class)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@Column(name="exchange_rate")
	@JacksonXmlProperty(localName = "exchange_rate")
	@JsonProperty(value = "exchange_rate")
	private Double exchangeRate;
	
	@Column(name="exchange_date")
	@JacksonXmlProperty(localName = "exchange_date")
	@JsonProperty(value = "exchange_date")
	private Date exchangeDate;

}
