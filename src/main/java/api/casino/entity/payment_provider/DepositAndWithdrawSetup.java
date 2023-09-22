package api.casino.entity.payment_provider;

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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import api.casino.entity.Currency;
import api.casino.entity.User;
import api.casino.entity.fee_system.FeeProfile;

@Entity
@Table(name="deposit_and_withdraw_setup")
@JacksonXmlRootElement(localName = "DepositAndWithdrawSetp")
public class DepositAndWithdrawSetup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	//1 or -1
	@Column(name="deposit_or_withdraw_status")
	private Integer depositOrWithdrawStatus;
	
	@ManyToOne(targetEntity = Currency.class)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@Column(name="email_verified_max_deposit")
	@JacksonXmlProperty(localName = "email_verified_max_deposit")
	@JsonProperty(value = "email_verified_max_deposit")
	private Double emailVerifiedMaxDeposit;
	
	/* Y or N */
	@Column(name="fee_enabled_status")
	@JacksonXmlProperty(localName = "fee_enabled_status")
	@JsonProperty(value = "fee_enabled_status")
	private String feeEnabledStatus;
	
	@ManyToOne(targetEntity = FeeProfile.class)
	@JoinColumn(name="fee_profile_id")
	private FeeProfile feeProfile;
	
	@Column(name="min_deposit_amount")
	@JacksonXmlProperty(localName = "min_deposit_amount")
	@JsonProperty(value = "min_deposit_amount")
	private Double minDepositAmount;
	
	@Column(name="max_deposit_amount")
	@JacksonXmlProperty(localName = "max_deposit_amount")
	@JsonProperty(value = "max_deposit_amount")
	private Double maxDepositAmount;
	
	@ManyToOne(targetEntity = PaymentProvider.class)
	@JoinColumn(name="payment_provider_id")
	private PaymentProvider paymentProvider;
	
	@ManyToOne(targetEntity = PaymentMethod.class)
	@JoinColumn(name="payment_method_id")
	private PaymentMethod paymentMethod;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	/* E - Enabled D - Disabled */
	@Column(name="status")
	@JacksonXmlProperty(localName = "status")
	@JsonProperty(value = "status")
	private String status;
	
	
}
