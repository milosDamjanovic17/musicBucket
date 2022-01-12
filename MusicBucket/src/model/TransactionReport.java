package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TransactionReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaction;
	@OneToOne
	private AccountDetails accDetails;
	@OneToOne
	private Tracks track;
	private Date date;
	
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	public AccountDetails getAccDetails() {
		return accDetails;
	}
	public void setAccDetails(AccountDetails accDetails) {
		this.accDetails = accDetails;
	}
	public Tracks getTrack() {
		return track;
	}
	public void setTrack(Tracks track) {
		this.track = track;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
