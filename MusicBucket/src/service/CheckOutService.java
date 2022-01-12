package service;

import dao.AccountDetailsDAO;
import dao.AddBalanceDAO;
import dao.CheckOutDAO;
import model.Account;
import model.AccountDetails;
import model.Tracks;

public class CheckOutService {

	CheckOutDAO dao = new CheckOutDAO();
	AddBalanceDAO balanceDao = new AddBalanceDAO();
	AccountDetailsDAO accDetailsDao = new AccountDetailsDAO();
	
	
	public Tracks returnTrackFromId(String idTrack) {
		
		
		
		
		return dao.returnTrackFromId(idTrack);
	}


	public Account returnAccFromId(String accId) {
		
		return balanceDao.returnAccFromId(accId);
	}


	public AccountDetails returnAccDetailsFromAcc(Account acc) {
		
		return accDetailsDao.returnAccDetailsObjectFromAccount(acc);
	}

}
