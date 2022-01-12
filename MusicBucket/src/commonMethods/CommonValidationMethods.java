package commonMethods;

import model.Account;
import model.AccountDetails;
import model.Role;
import model.Tracks;

public class CommonValidationMethods {


	
	public boolean blankInputsCheck(String username, String password, String repeatedPassword, String email) {
		
		if(username.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty() || email.isEmpty()) {
			System.out.println("Registration form polja su prazna...........");
			return false;
		}else {
			System.out.println("Registration form polja su popunjena......");
			return true;
		}
		
	}
	
	//OVERLOAD
	public boolean blankInputsCheck(String username, String password) {
		
		if(username.isEmpty() || password.isEmpty()) {
			System.out.println("nisu popunjena sva polja.....");
			return false;
		}else {
			System.out.println("sva su polja popunjena.....");
			return true;
		}
	}
	

	public boolean passwordConditionsCheck(String password) {

		if(password.length() < 4) {
			System.out.println("password mora imati 4 ili vise karaktera.....");
			return false;
		}
		
		int digitCounter = 0;
		int upperCaseCounter = 0;
		
		for(int i = 0; i < password.length(); i++) {
			char localChar = password.charAt(i);
			if(Character.isDigit(localChar)) {
				digitCounter++;
			}else if(Character.isUpperCase(localChar)) {
				upperCaseCounter++;
			}
			
		}
		
		if(digitCounter > 0 && upperCaseCounter > 0) {
			System.out.println("svi uslovi za password su ispunjeni....");
			return true;
		}else {
			System.out.println("uslovi za password nisu ispunjeni...");
			return false;
		}
		

	}

	public boolean passwordMatchCheck(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			System.out.println("passwordi se podudaraju...");
			return true;
		}else {
			System.out.println("passwordi nisu isti...");
			return false;
		}
		
	}

	public boolean emailCheck(String email) {
		
		int monkeyCounter = 0;
		//int dotCounter = 0;
		boolean endCheck = email.endsWith(".com");
		
		for(int i = 0; i < email.length(); i++) {
			char localChar = email.charAt(i);
			if(localChar == '@') {
				monkeyCounter++;
			}/*else if(localChar == '.') {
				dotCounter++;
			}*/
		}
		
		if(monkeyCounter == 1 &&  endCheck) {
			System.out.println("mail je validan...");
			return true;
		}else {
			System.out.println("mail nije validan....");
			return false;
		}
		
	}

	public Account setupAccount(String username, String password, String email) {

		Account acc = new Account();
			acc.setUsername(username);
			acc.setPassword(password);
			acc.setEmail(email);
			acc.setRole(Role.USER);
		
		
		return acc;
	}

	public AccountDetails setupAccountDetails(String name, String djName, String description, String url,
			String genre) {
		
		AccountDetails accDetailsLocal = new AccountDetails();
			accDetailsLocal.setName(name);
			accDetailsLocal.setDjName(djName);
			accDetailsLocal.setDescription(description);
			accDetailsLocal.setUrl(url);
			accDetailsLocal.setPreferedGenre(genre);
			accDetailsLocal.setBalance(0.0);
		
		
		return accDetailsLocal;
	}

	//OVERLOAD
	public boolean blankInputsCheck(String name, String djName, String description, String url, String genre) {
		if(name.isEmpty() || djName.isEmpty() || description.isEmpty() || url.isEmpty() || genre.isEmpty()) {
			return false;
		}else {
			System.out.println("sva polja su popunjena...");
			return true;
		}
	}

	public boolean isAmountDouble(String amount) {
		
		if(amount.matches("[0-9]+")) {
			System.out.println("unet iznos je digit!");
			return true;
		}else {
			System.out.println("unet iznos mora da ima iskljucivo cifre...");
			return false;
		}
		
	}

	public boolean isCardNumberValid(String cardNumber) {
		
		int digitCounter = 0;
		//int dashCounter = 0;
		char[] ch = cardNumber.toCharArray();
		
		for(int i = 0; i < cardNumber.length(); i++) {
			char localChar = cardNumber.charAt(i);
			if(Character.isDigit(localChar)) {
				digitCounter++;
			}/*else if(localChar == '-') {
				dashCounter++;
			}*/
		}
		
		if(digitCounter >= 13 && digitCounter <= 19 && ch[4] == '-' && ch[9] == '-' && ch[14] == '-') {
			System.out.println("validan tip kartice...");
			return true;
		}else {
			System.out.println("neispravan tip kartice....");
			return false;
		}

	}

	public boolean blankInputsCheck(String artist, String title, String bpm, String genre, String label, String year,
			String price) {
		
		if(artist.isEmpty() || title.isEmpty() || bpm.isEmpty() || genre.isEmpty() || label.isEmpty() || year.isEmpty() || price.isEmpty()) {
			System.out.println("popuni sva polja!");
			return false;
		}else {
			System.out.println("polja su popunjena...........");
			return true;
		}

	}

	public boolean isAmountDoubleForPrice(String price) {
		
		if(price.length() == 4) {
			
			char[] chArray = price.toCharArray();
			
			if(Character.isDigit(chArray[0]) && chArray[1] == '.' && Character.isDigit(chArray[2]) && Character.isDigit(chArray[3])) {
				System.out.println("prosla validacija.........");
				return true;
			}else {
				System.out.println("proveri inpute i uslove opet......");
				return false;
			}
			
			
		}else {
			System.out.println("mora da ima tacno 4 karaktera zajedno za tackom!");
			return false;
		}
		
	}

	public Tracks setupTrack(String artist, String title, String bpm, String genre, String label, String year,
			Double priceInDouble) {
		
		Tracks local = new Tracks();
			local.setArtist(artist);
			local.setTitle(title);
			local.setBpm(bpm);
			local.setGenre(genre);
			local.setLabel(label);
			local.setYear(year);
			local.setPrice(priceInDouble);
		
		return local;
	}

}
