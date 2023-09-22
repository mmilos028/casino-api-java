package api.casino.entity.limits;

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

import api.casino.entity.Currency;

@Entity
@Table(name="withdraw_limits_for_non_kyc")
@JacksonXmlRootElement(localName = "WithdrawLimitForNonKyc")
public class WithdrawLimitForNonKyc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@ManyToOne(targetEntity = Currency.class)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@Column(name="amount")
	@JacksonXmlProperty(localName = "amount")
	@JsonProperty(value = "amount")
	private Double amount;

}
