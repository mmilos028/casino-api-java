package api.casino.entity.bonus_system;

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

import api.casino.entity.Game;

@Entity
@Table(name="promotion_per_game")
@JacksonXmlRootElement(localName = "PromotionPerGame")
public class PromotionPerGame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@ManyToOne(targetEntity = Game.class)
	@JoinColumn(name="game_id")
	private Game game;
	
	//E - Enabled, D - Disabled 
	@Column(name="status")
	@JacksonXmlProperty(localName = "status")
	@JsonProperty(value = "status")
	private String status;
	
	
}
