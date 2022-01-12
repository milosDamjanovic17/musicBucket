package service;

import dao.RegistrationDAO;
import model.Account;


public class RegistrationService {

	RegistrationDAO dao = new RegistrationDAO();

	public Account checkIfUsernameExists(Account acc) {

		return dao.checkIfUsernameExists(acc);
	}

	public boolean saveAccountInDB(Account acc) {
		// TODO Auto-generated method stub
		return dao.saveAccountInDB(acc);
	}
	
	


}
