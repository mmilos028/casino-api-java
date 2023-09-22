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
@Table(name="fee_profile")
@JacksonXmlRootElement(localName = "FeeProfile")
public class FeeProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="fee_name")
	@JacksonXmlProperty(localName = "fee_name")
	@JsonProperty(value = "fee_name")
	private String feeName;
	
	/*
	 * 1-Deposit Fee, 2-Withdraw Fee, 3-Inactivity Fee
	 */
	@Column(name="fee_type_id")
	@JacksonXmlProperty(localName = "fee_type_id")
	@JsonProperty(value = "fee_type_id")
	private Integer feeTypeId;
	
	/**
	 * Must be positive number. If nullable then must fullfil FEE_PROFILE_VALUE.FEE_FIX_AMOUNT.
	 */
	@Column(name="fee_percent")
	@JacksonXmlProperty(localName = "fee_percent")
	@JsonProperty(value = "fee_percent")
	private Double feePercent;
	
	/**
	 * Inactivity in days.>180 days Fee_Fix_Amount
	 */
	@Column(name="inactivity_period")
	@JacksonXmlProperty(localName = "inactivity_period")
	@JsonProperty(value = "inactivity_period")
	private Double inactivityPeriod;
	
	/**
	 * If inactive >180 days, every 30 days, takes off fee for inactivity.
	 */
	@Column(name="inactivity_retrigger")
	@JacksonXmlProperty(localName = "inactivity_retrigger")
	@JsonProperty(value = "inactivity_retrigger")
	private Double inactivityRetrigger;
	
	/**
	 * Record status for WLs fee profile. Active, Cancelled
	 */
	@Column(name="status")
	@JacksonXmlProperty(localName = "status")
	@JsonProperty(value = "status")
	private String status;
	
	/**
	 * Profile description
	 */
	@Column(name="profile_description")
	@JacksonXmlProperty(localName = "profile_description")
	@JsonProperty(value = "profile_description")
	private String profileDescription;
}
