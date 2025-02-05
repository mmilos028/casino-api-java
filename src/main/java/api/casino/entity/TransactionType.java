package api.casino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_type")
public class TransactionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String description;
	
	@Column(name="transaction_sign")
	private Integer transactionSign;

	public TransactionType() {

	}

	public TransactionType(Long id, String name, String description, Integer transactionSign) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.transactionSign = transactionSign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTransactionSign() {
		return transactionSign;
	}

	public void setTransactionSign(Integer transactionSign) {
		this.transactionSign = transactionSign;
	}

}
