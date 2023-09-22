package api.casino.entity.bonus_system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import api.casino.entity.User;

@Entity
@Table(name="bonus_for_user")
@JacksonXmlRootElement(localName = "BonusForUser")
public class BonusForUser {
	
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

}
