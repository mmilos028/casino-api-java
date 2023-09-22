package api.casino.entity.transactions;

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

import api.casino.entity.TransactionType;
import api.casino.entity.User;

@Entity
@Table(name="vivo_gaming_transactions")
public class VivoGamingTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="vivo_gaming_id")
	@JacksonXmlProperty(localName = "vivo_gaming_id")
	@JsonProperty(value = "vivo_gaming_id")
	private Integer vivoGamingId;
	
	@ManyToOne(targetEntity=TransactionType.class, fetch=FetchType.EAGER)
	@JoinColumn(name="transaction_type_id")
	private TransactionType transactionType;
	
	@Column(name="transaction_description")
	@JacksonXmlProperty(localName = "transaction_description")
	@JsonProperty(value = "transaction_description")
	private String transactionDescription;
	
	@Column(name="round_id")
	@JacksonXmlProperty(localName = "round_id")
	@JsonProperty(value = "round_id")
	private Integer roundId;
	
	@Column(name="game_id")
	@JacksonXmlProperty(localName = "game_id")
	@JsonProperty(value = "game_id")
	private String gameId;
	
	@Column(name="history")
	@JacksonXmlProperty(localName = "history")
	@JsonProperty(value = "history")
	private String history;
	
	@Column(name="is_round_finished")
	@JacksonXmlProperty(localName = "is_round_finished")
	@JsonProperty(value = "is_round_finished")
	private Integer isRoundFinished;
	
	@Column(name="transaction_id")
	@JacksonXmlProperty(localName = "transaction_id")
	@JsonProperty(value = "transaction_id")
	private Integer transactionId;
	
	@Column(name="vivo_transaction_id")
	@JacksonXmlProperty(localName = "vivo_transaction_id")
	@JsonProperty(value = "vivo_transaction_id")
	private Integer vivoTransactionId;
	
	@Column(name="transaction_sign")
	@JacksonXmlProperty(localName = "transaction_sign")
	@JsonProperty(value = "transaction_sign")
	private Integer transactionSign;
}
