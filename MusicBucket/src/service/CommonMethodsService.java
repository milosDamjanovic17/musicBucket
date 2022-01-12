package service;

import commonMethods.CommonValidationMethods;
import model.Account;
import model.AccountDetails;
import model.Tracks;

public class CommonMethodsService {

	CommonValidationMethods common = new CommonValidationMethods();
	
	
	public boolean blankInputsCheck(String username, String password, String repeatedPassword, String email) {

		return common.blankInputsCheck(username, password, repeatedPassword, email);
	}


	public boolean passwordConditionsCheck(String password) {

		return common.passwordConditionsCheck(password);
	}


	public boolean passwordMatchCheck(String password, String repeatedPassword) {
		
		return common.passwordMatchCheck(password, repeatedPassword);
	}


	public boolean emailCheck(String email) {

		return common.emailCheck(email);
	}


	public Account setupAccount(String username, String password, String email) {

		return common.setupAccount(username,password,email);
	}


	public boolean blankInputsCheck(String username, String password) {
		
		return common.blankInputsCheck(username, password);
	}


	public AccountDetails setupAccountDetails(String name, String djName, String description, String url,
			String genre) {
	
		return common.setupAccountDetails(name, djName, description, url, genre);
	}


	public boolean blankInputsCheck(String name, String djName, String description, String url, String genre) {
		
		return common.blankInputsCheck(name, djName, description, url, genre);
	}


	public boolean isAmountDouble(String amount) {
		
		return common.isAmountDouble(amount);
	}


	public boolean isCardNumberValid(String cardNumber) {
		
		return common.isCardNumberValid(cardNumber);
	}


	public boolean blankInputsCheck(String artist, String title, String bpm, String genre, String label, String year,
			String price) {
		
		return common.blankInputsCheck(artist, title, bpm, genre, label, year, price);
	}


	public boolean isAmountDoubleForPrice(String price) {
		
		return common.isAmountDoubleForPrice(price);
	}


	public Tracks setupTrack(String artist, String title, String bpm, String genre, String label, String year,
			Double priceInDouble) {
		
		return common.setupTrack(artist, title, bpm, genre, label, year, priceInDouble);
	}


}
