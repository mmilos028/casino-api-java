package api.casino.entity.bonus_system;

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
@Table(name="bonus_profile")
@JacksonXmlRootElement(localName = "BonusProfile")
public class BonusProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@Column(name="profile_name")
	@JacksonXmlProperty(localName = "profile_name")
	@JsonProperty(value = "profile_name")
	private String profileName;
	
	/**
	 * Multiplication Procenat za koji se uvecava iznos uplate (100% na uplatu, uplati 200 i dobije bonus 200)
	 */
	@Column(name="bonus_multiplier")
	@JacksonXmlProperty(localName = "bonus_multiplier")
	@JsonProperty(value = "bonus_multiplier")
	private Double bonusMultiplier;
	
	/**
	 * Broj koji definise iznos Wagering_Required u Bonus_Balance tabeli.
	 */
	@Column(name="wagering_multiplier")
	@JacksonXmlProperty(localName = "wagering_multiplier")
	@JsonProperty(value = "wagering_multiplier")
	private Double wageringMultiplier;
	
	/**
	 * Broj dana. Ako za taj period ne bude ispunjen predhodni uslov (Wagering Request), 
	 * preostali deo od Deposit (ako ga ima) prestaje da bude ”Restricted”, celokupan iznos Bonusa se brise, 
	 * a brise se i celokupan ostvareni dobitak.
	 */
	@Column(name="restricted_period")
	@JacksonXmlProperty(localName = "restricted_period")
	@JsonProperty(value = "restricted_period")
	private Integer restrictedPeriod;
	
	@Column(name="profile_description")
	@JacksonXmlProperty(localName = "profile_description")
	@JsonProperty(value = "profile_description")
	private String profileDescription;
	
	/**
	 * Active, Cancelled
	 */
	@Column(name="profile_status")
	@JacksonXmlProperty(localName = "profile_status")
	@JsonProperty(value = "profile_status")
	private String profileStatus;
}
