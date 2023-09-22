package api.casino.entity.bonus_system;

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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="bonus_campaign")
@JacksonXmlRootElement(localName = "BonusCampaign")
public class BonusCampaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="campaign_name")
	@JacksonXmlProperty(localName = "campaign_name")
	@JsonProperty(value = "campaign_name")
	private String campaignName;
	
	@Column(name="campaign_code")
	@JacksonXmlProperty(localName = "campaign_code")
	@JsonProperty(value = "campaign_code")
	private String campaignCode;

	@Column(name="campaign_start_date")
	@JacksonXmlProperty(localName = "campaign_start_date")
	@JsonProperty(value = "campaign_start_date")
	private Date campaignStartDate;
	
	@Column(name="campaign_end_date")
	@JacksonXmlProperty(localName = "campaign_end_date")
	@JsonProperty(value = "campaign_end_date")
	private String campaignEndDate;
	
	@Column(name="campaign_description")
	@JacksonXmlProperty(localName = "campaign_description")
	@JsonProperty(value = "campaign_description")
	private String campaignDescription;
	
	/* Flag da li ce se odredjena kampanja ponavljati. Moguce oznake su: W - week, M - Month, N - not repeat */
	@Column(name="campaign_repeat")
	@JacksonXmlProperty(localName = "campaign_repeat")
	@JsonProperty(value = "campaign_repeat")
	private String campaignRepeat;
	
	/* Status da li je kampanja aktivna ili ne za koriscenje. Active, Cancelled */
	@Column(name="campaign_status")
	@JacksonXmlProperty(localName = "campaign_status")
	@JsonProperty(value = "campaign_status")
	private String campaignStatus;
	
	@ManyToOne(targetEntity = BonusProfile.class, fetch = FetchType.EAGER)
	@JoinColumn(name="bonus_profile_id")
	private BonusProfile bonusProfile;
}
