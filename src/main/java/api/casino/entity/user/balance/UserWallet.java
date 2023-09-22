package api.casino.entity.user.balance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import api.casino.entity.Currency;
import api.casino.entity.User;

@Entity
@Table(name="user_wallet")
public class UserWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double balance;
	
	@ManyToOne(targetEntity = Currency.class)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
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

	public UserWallet(Long id, Double balance, Currency currency, User user, BalanceType balanceType) {
		super();
		this.id = id;
		this.balance = balance;
		this.currency = currency;
		this.user = user;
		this.balanceType = balanceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
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
