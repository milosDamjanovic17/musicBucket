package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import service.CommonMethodsService;
import service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(description = "kontroler za regulisanje i validaciju registracije korisnika", urlPatterns = { "/RegistrationController" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommonMethodsService common = new CommonMethodsService();
		RegistrationService service = new RegistrationService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String email = request.getParameter("email");
		
		boolean blankInputs = common.blankInputsCheck(username, password,repeatedPassword, email);
		boolean passwordMatch = common.passwordMatchCheck(password, repeatedPassword);
		boolean passwordCheck = common.passwordConditionsCheck(password);
		boolean emailCheck = common.emailCheck(email);
		
		
		if(blankInputs && passwordMatch && passwordCheck && emailCheck) {
			
			Account acc = common.setupAccount(username,password,email);
			
			Account checkIfUsernameExists = service.checkIfUsernameExists(acc);
			if(checkIfUsernameExists != null) {
				boolean saveAccountInDB = service.saveAccountInDB(checkIfUsernameExists);
					if(saveAccountInDB) {
						response.sendRedirect("LoginPages/login.html");
					}else {
						response.sendRedirect("RegistrationPages/registrationInternalServerError.html");
					}
			}else {
				response.sendRedirect("RegistrationPages/registrationAccountExists.html");
			}
			
		}else {
			response.sendRedirect("RegistrationPages/registrationInputFail.html");
		}
		
	}

}
