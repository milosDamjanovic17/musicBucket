package service;

import dao.LoginDAO;
import model.Account;

public class LoginService {

	LoginDAO dao = new LoginDAO();
	
	
	public Account returnAccFromLoginInput(String username, String password) {

		return dao.returnAccFromLoginInput(username,password);
	}

}
