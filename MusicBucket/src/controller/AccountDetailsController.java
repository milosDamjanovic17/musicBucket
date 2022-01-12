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
import service.AccountDetailsService;
import service.CommonMethodsService;

/**
 * Servlet implementation class AccountDetailsController
 */
@WebServlet(description = "kontroler za regulisanje account details", urlPatterns = { "/AccountDetailsController" })
public class AccountDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		CommonMethodsService common = new CommonMethodsService();
		AccountDetailsService service = new AccountDetailsService();
		
		
		String name = request.getParameter("name");
		String djName = request.getParameter("djName");
		String description = request.getParameter("description");
		String url = request.getParameter("url");
		String genre = request.getParameter("genre");
		String id = request.getParameter("id");
		
		Account acc = service.returnAccountFromId(id);
		
		boolean blankInputsCheck = common.blankInputsCheck(name, djName, description, url, genre);
		if(blankInputsCheck) {
			if(acc != null) {
				AccountDetails accDetailsObject = service.returnAccDetailsObjectFromAccount(acc);
				boolean updateAccountDetails = service.updateAccountDetails(name, djName, description, url, genre, accDetailsObject);
				if(updateAccountDetails) {
					response.sendRedirect("AccountPages/accountDetailsEditSuccess.jsp");
				}else {
					response.sendRedirect("AccountPages/accountDetailsEditFailed.jsp");
				}
				
			}else {
				response.sendRedirect("AccountPages/accountDetailsEditFailed.jsp");
			}
		
		}else {
			response.sendRedirect("AccountPages/accountDetailsEditFailed.jsp");
		}
	}

}
