package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AccountDetails;
import model.Role;
import service.CommonMethodsService;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "kontroler za regulisanje operacija logina", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommonMethodsService common = new CommonMethodsService();
		LoginService service = new LoginService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean blankInputsCheck = common.blankInputsCheck(username, password);
		
		if(blankInputsCheck) {
			
			Account acc = service.returnAccFromLoginInput(username,password);
			System.out.println("WELCOME: " +acc.getUsername());
			if(acc != null) {
				AccountDetails accDetails = new AccountDetails();
					accDetails.setAccount(acc);
				//ako postoji Account smestam ga u HttpSession Object.....
				HttpSession session = request.getSession();
				//smestanje Accounta u httpSession
				session.setAttribute("accKey", acc);
				if(acc.getRole().equals(Role.USER)) {
					response.sendRedirect("AccountPages/homePage.jsp");
				}else {
					response.sendRedirect("AccountPages/homePageAdmin.jsp");
				}
				
			}else {
				response.sendRedirect("LoginPages/loginDidntFindAcc.html");
			}
			
		}else {
			response.sendRedirect("LoginPages/loginEmptyInput.html");
		}
		
		
		
		
		
	}

}
