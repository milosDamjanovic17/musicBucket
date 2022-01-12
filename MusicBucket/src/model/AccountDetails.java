package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccountDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccDetails;
	private String name = "default";
	private String djName = "default";
	private String description = "default"; // bio == description
	private String url = "default";
	private String preferedGenre = "default";
	private Double balance = 0.0;
	@OneToOne
	private Account account;
	
	public Integer getIdAccDetails() {
		return idAccDetails;
	}
	public void setIdAccDetails(Integer idAccDetails) {
		this.idAccDetails = idAccDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDjName() {
		return djName;
	}
	public void setDjName(String djName) {
		this.djName = djName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPreferedGenre() {
		return preferedGenre;
	}
	public void setPreferedGenre(String preferedGenre) {
		this.preferedGenre = preferedGenre;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}
