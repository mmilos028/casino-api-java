package api.casino.entity.transactions;

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

import api.casino.entity.Currency;
import api.casino.entity.TransactionType;
import api.casino.entity.User;
import api.casino.entity.payment_provider.PaymentMethod;
import api.casino.entity.user.session.Session;

@Entity
@Table(name="cash_transactions")
public class CashTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity=Session.class, fetch=FetchType.EAGER)
	@JoinColumn(name="session_id")
	private Session session;
	
	@ManyToOne(targetEntity=TransactionType.class, fetch=FetchType.EAGER)
	@JoinColumn(name="transaction_type_id")
	private TransactionType transactionType;
	
	@Column(name="insert_date")
	@JacksonXmlProperty(localName = "insert_date")
	@JsonProperty(value = "insert_date")
	private Date insertDate;
	
	@Column(name="update_date")
	@JacksonXmlProperty(localName = "update_date")
	@JsonProperty(value = "update_date")
	private Date updateDate;
	
	@Column(name="balance")
	@JacksonXmlProperty(localName = "balance")
	@JsonProperty(value = "balance")
	private Double balance;
	
	@Column(name="transaction_amount")
	@JacksonXmlProperty(localName = "transaction_amount")
	@JsonProperty(value = "transaction_amount")
	private Double transactionAmount;
	
	@Column(name="transaction_sign")
	@JacksonXmlProperty(localName = "transaction_sign")
	@JsonProperty(value = "transaction_sign")
	private Integer transactionSign;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="from_user_id")
	private User fromUser;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="to_user_id")
	private User toUser;
	
	@ManyToOne(targetEntity=Currency.class, fetch=FetchType.EAGER)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@Column(name="additional_field1")
	@JacksonXmlProperty(localName = "additional_field1")
	@JsonProperty(value = "additional_field1")
	private String additionalField1;
	
	@Column(name="additional_field2")
	@JacksonXmlProperty(localName = "additional_field2")
	@JsonProperty(value = "additional_field2")
	private String additionalField2;
	
	@Column(name="additional_field3")
	@JacksonXmlProperty(localName = "additional_field3")
	@JsonProperty(value = "additional_field3")
	private String additionalField3;
	
	@Column(name="additional_field4")
	@JacksonXmlProperty(localName = "additional_field4")
	@JsonProperty(value = "additional_field4")
	private String additionalField4;
	
	@Column(name="additional_field5")
	@JacksonXmlProperty(localName = "additional_field5")
	@JsonProperty(value = "additional_field5")
	private String additionalField5;
	
	@Column(name="additional_field6")
	@JacksonXmlProperty(localName = "additional_field6")
	@JsonProperty(value = "additional_field6")
	private String additionalField6;
	
	@Column(name="additional_field7")
	@JacksonXmlProperty(localName = "additional_field7")
	@JsonProperty(value = "additional_field7")
	private String additionalField7;
	
	@Column(name="additional_field8")
	@JacksonXmlProperty(localName = "additional_field8")
	@JsonProperty(value = "additional_field8")
	private String additionalField8;
	
	@Column(name="additional_field9")
	@JacksonXmlProperty(localName = "additional_field9")
	@JsonProperty(value = "additional_field9")
	private String additionalField9;
	
	@Column(name="additional_field10")
	@JacksonXmlProperty(localName = "additional_field10")
	@JsonProperty(value = "additional_field10")
	private String additionalField10;
	
	@Column(name="external_sequence")
	@JacksonXmlProperty(localName = "external_sequence")
	@JsonProperty(value = "external_sequence")
	private String externalSequence;
	
	@ManyToOne(targetEntity=PaymentMethod.class, fetch=FetchType.EAGER)
	@JoinColumn(name="payment_method_id")
	private PaymentMethod paymentMethod;
	
	
	
	

}
