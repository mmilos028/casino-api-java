package api.casino.entity.fee_system;

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
import api.casino.entity.payment_provider.PaymentMethod;

@Entity
@Table(name="internal_payment_fee")
@JacksonXmlRootElement(localName = "internal_payment_fee")
public class InternalPaymentFee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;

	@Column(name="min_amount")
	@JacksonXmlProperty(localName = "min_amount")
	@JsonProperty(value = "min_amount")
	private Double minAmount;
	
	@Column(name="max_amount")
	@JacksonXmlProperty(localName = "max_amount")
	@JsonProperty(value = "max_amount")
	private Double maxAmount;
	
	@Column(name="fix_amount")
	@JacksonXmlProperty(localName = "fix_amount")
	@JsonProperty(value = "fix_amount")
	private Double fixAmount;
	
	@Column(name="fix_percent")
	@JacksonXmlProperty(localName = "fix_percent")
	@JsonProperty(value = "fix_percent")
	private Double fixPercent;
	
	@Column(name="charge_back")
	@JacksonXmlProperty(localName = "charge_back")
	@JsonProperty(value = "charge_back")
	private Double chargeBack;
	
	@ManyToOne(targetEntity = Currency.class)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	//1 - Deposit or -1 - Withdraw
	@Column(name="transaction_sign")
	@JacksonXmlProperty(localName = "transaction_sign")
	@JsonProperty(value = "transaction_sign")
	private Integer transactionSign;
	
	@ManyToOne(targetEntity = PaymentMethod.class)
	@JoinColumn(name="payment_method_id")
	private PaymentMethod paymentMethod;
	
	@Column(name="payment_provider_addition")
	@JacksonXmlProperty(localName = "payment_provider_addition")
	@JsonProperty(value = "payment_provider_addition")
	private Double paymentProviderAddition;
}
