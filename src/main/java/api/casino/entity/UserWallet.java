package api.casino.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_wallet")
public class UserWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float balance;
	
	private String currency;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(targetEntity = BalanceType.class)
	@JoinColumn(name="balance_type_id")
	private BalanceType balanceType;

	public UserWallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserWallet(int id, float balance, String currency, User user, BalanceType balanceType) {
		super();
		this.id = id;
		this.balance = balance;
		this.currency = currency;
		this.user = user;
		this.balanceType = balanceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BalanceType getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(BalanceType balanceType) {
		this.balanceType = balanceType;
	}	
	
}
