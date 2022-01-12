package service;

import dao.AddBalanceDAO;
import model.Account;

public class AddBalanceService {

	AddBalanceDAO dao = new AddBalanceDAO();
	
	
	public Account returnAccFromId(String id) {
		// TODO Auto-generated method stub
		return dao.returnAccFromId(id);
	}


	public boolean addBalance(Account acc, Double amountDouble) {
		
		return dao.addBalance(acc, amountDouble);
	}

}
