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

import api.casino.entity.Currency;
import api.casino.entity.User;

@Entity
@Table(name="bonus_balance")
@JacksonXmlRootElement(localName = "BonusBalance")
public class BonusBalance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(targetEntity=BonusCampaign.class, fetch=FetchType.EAGER)
	@JoinColumn(name="bonus_campaign_id")
	private BonusCampaign bonusCampaign;
	
	@Column(name="credits_restricted")
	@JacksonXmlProperty(localName = "credits_restricted")
	@JsonProperty(value = "credits_restricted")
	private Double creditsRestricted;
	
	@Column(name="bonus_restricted")
	@JacksonXmlProperty(localName = "bonus_restricted")
	@JsonProperty(value = "bonus_restricted")
	private Double bonusRestricted;
	
	@Column(name="bonus_win_restricted")
	@JacksonXmlProperty(localName = "bonus_win_restricted")
	@JsonProperty(value = "bonus_win_restricted")
	private Double bonusWinRestricted;
	
	@Column(name="promotion")
	@JacksonXmlProperty(localName = "promotion")
	@JsonProperty(value = "promotion")
	private Double promotion;
	
	/* Wagering oznacava uslov koliko igrac treba da odigra da bi mu RESTRICTED krediti bili oslobodjeni i premesteni u SUBJECTS.CREDIT polje za odredjenog igraca. */
	@Column(name="wagering_required")
	@JacksonXmlProperty(localName = "wagering_required")
	@JsonProperty(value = "wagering_required")
	private Double wageringRequired;

	/* Iznos koliko je odredjeni igrac odigrao u toku jedne Bonus kampanje. */
	@Column(name="wagering_played")
	@JacksonXmlProperty(localName = "wagering_played")
	@JsonProperty(value = "wagering_played")
	private Double wageringPlayed;
	
	/* Od kog datuma vazi bonus za odredjenog igraca i bonus kampanje koju je pokrenuo. */
	@Column(name="bonus_start_date")
	@JacksonXmlProperty(localName = "bonus_start_date")
	@JsonProperty(value = "bonus_start_date")
	private Date bonusStartDate;
	
	/* Do kog datuma vazi bonus za odredjenog igraca i bonus kampanje koju je pokrenuo. Posle ovog datuma ce se ponistiti svi restricted bonusi ako nije ispunjen uslov iz Wagering_Required. */
	@Column(name="bonus_end_date")
	@JacksonXmlProperty(localName = "bonus_end_date")
	@JsonProperty(value = "bonus_end_date")
	private Date bonusEndDate;
	
	/* trenutni status bonus-a za igraca: Active, Cancelled, Expired, Fulfilled, Used */
	@Column(name="bonus_balance_status")
	@JacksonXmlProperty(localName = "bonus_balance_status")
	@JsonProperty(value = "bonus_balance_status")
	private String bonusBalanceStatus;
	
	@ManyToOne(targetEntity = Currency.class, fetch = FetchType.EAGER)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	/* kolko je inicijalno dobio od casina bonus kredita (procenat od njegove uplate) radi istorije koja se kasnije gleda */
	@Column(name="bonus_restricted_initial")
	@JacksonXmlProperty(localName = "bonus_restricted_initial")
	@JsonProperty(value = "bonus_restricted_initial")
	private Double bonusRestrictedInitial;
}
