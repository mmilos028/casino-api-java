package api.casino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TransactionType")
@Table(name="transaction_type")
public class TransactionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	
	private String description;
	
	@Column(name="transaction_sign")
	private int transactionSign;

	public TransactionType() {

	}

	public TransactionType(int id, String name, String description, int transactionSign) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.transactionSign = transactionSign;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getTransactionSign() {
		return transactionSign;
	}

	public void setTransactionSign(int transactionSign) {
		this.transactionSign = transactionSign;
	}

}
