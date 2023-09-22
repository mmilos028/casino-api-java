package api.casino.entity.fee_system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="fee_profile_value")
@JacksonXmlRootElement(localName = "FeeProfileValue")
public class FeeProfileValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = FeeProfile.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fee_profile_id")
	private FeeProfile feeProfile;
	
	@Column(name="currency")
	@JacksonXmlProperty(localName = "currency")
	@JsonProperty(value = "currency")
	private String currency;
	
	/* Fix amount of fee. Must be entered if FEE_PROFILE.FEE_PERCENT is empty.Mandatory for Inactivity Fee. */
	@Column(name="fix_amount")
	@JacksonXmlProperty(localName = "fix_amount")
	@JsonProperty(value = "fix_amount")
	private Double fixAmount;
	
	/* Minimal amount of fee for charge. Amount of fee can not be lower then this. */
	@Column(name="min_amount")
	@JacksonXmlProperty(localName = "min_amount")
	@JsonProperty(value = "min_amount")
	private Double minAmount;
	
	/* Maximal amount of fee for charge. Amount of fee can not be greater than this. */
	@Column(name="max_amount")
	@JacksonXmlProperty(localName = "max_amount")
	@JsonProperty(value = "max_amount")
	private Double maxAmount;
	
	/* If amount > No_Fee for Deposit Type, there will be no charge. Minimal amont for fee free. */
	@Column(name="no_fee_min_amount")
	@JacksonXmlProperty(localName = "no_fee_min_amount")
	@JsonProperty(value = "no_fee_min_amount")
	private Double noFeeMinAmount;
	
	
	

}
