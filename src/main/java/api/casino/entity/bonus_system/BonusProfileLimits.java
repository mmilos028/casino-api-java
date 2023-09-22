package api.casino.entity.bonus_system;

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

@Entity
@Table(name="bonus_profile_limits")
@JacksonXmlRootElement(localName = "BonusProfileLimits")
public class BonusProfileLimits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	/* Maximalan iznos bonusa do kojeg se duplira (Max=300, Player uplati 500 i dobije jos 300) */
	@Column(name="max_amount")
	@JacksonXmlProperty(localName = "max_amount")
	@JsonProperty(value = "max_amount")
	private Double maxAmount;
	
	/* Minimalan iznos depozita. Ako je ovo polje prazno onda se nece uzimati u obzir. */
	@Column(name="min_deposit")
	@JacksonXmlProperty(localName = "min_deposit")
	@JsonProperty(value = "min_deposit")
	private Double minDeposit;
	
	/* Iznos koji ce se odnositi na odredjene promocije. */
	@Column(name="promotion_amount")
	@JacksonXmlProperty(localName = "promotion_amount")
	@JsonProperty(value = "promotion_amount")
	private Double promotionAmount;
	
	@ManyToOne(targetEntity = Currency.class, fetch = FetchType.EAGER)
	@JoinColumn(name="currency_id")
	private Currency currency;
}
