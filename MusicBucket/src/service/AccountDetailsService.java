package service;

import dao.AccountDetailsDAO;
import model.Account;
import model.AccountDetails;

public class AccountDetailsService {

	AccountDetailsDAO dao = new AccountDetailsDAO();
	
	
	public Account returnAccountFromId(String id) {
				
		return dao.returnAccountFromId(id);
	}


	public AccountDetails returnAccDetailsObjectFromAccount(Account acc) {

		return dao.returnAccDetailsObjectFromAccount(acc);
	}


	public boolean updateAccountDetails(String name, String djName, String description, String url, String genre,
			AccountDetails accDetailsObject) {

		return dao.updateAccountDetails(name, djName, description, url, genre, accDetailsObject);
	}



}
