package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import service.AddBalanceService;
import service.CommonMethodsService;

/**
 * Servlet implementation class AddBalanceController
 */
@WebServlet(description = "kontroler za regulisanje dodavanje sredstava za placanje", urlPatterns = { "/AddBalanceController" })
public class AddBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommonMethodsService common = new CommonMethodsService();
		AddBalanceService service = new AddBalanceService();
		
		
		String cardNumber = request.getParameter("cardNumber");
		String amount = request.getParameter("amount");
		String id = request.getParameter("id");
		
		boolean blankInputsCheck = common.blankInputsCheck(cardNumber, amount);
		boolean isAmountDouble = common.isAmountDouble(amount);
		boolean isCardNumberValid = common.isCardNumberValid(cardNumber);
		
		if(blankInputsCheck && isAmountDouble && isCardNumberValid) {
			Double amountDouble = Double.parseDouble(amount);
			
			
			Account acc = service.returnAccFromId(id);
			if(acc != null) {
				boolean addBalance = service.addBalance(acc, amountDouble);
				if(addBalance) {
					response.sendRedirect("BalancePages/balanceCompleted.jsp");
				}else {
					response.sendRedirect("BalancePages/balanceServerResponseFail.jsp");
				}
			}else {
				response.sendRedirect("BalancePages/balanceServerResponseFail.jsp");
			}
			
		}else {
			response.sendRedirect("BalancePages/balanceCheckInputs.jsp");
		}
		
		
		
	}

}
