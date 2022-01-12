package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.AccountDetails;
import model.Tracks;
import service.CheckOutService;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet(description = "kontroler za regulisanje i pregled kupovine", urlPatterns = { "/CheckOutController" })
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CheckOutService service = new CheckOutService();
		
		String idTrack = request.getParameter("idTrack");
		String accId = request.getParameter("accId");
		
		System.out.println(idTrack);
		System.out.println(accId);
		
		
		Tracks tracks = service.returnTrackFromId(idTrack);
		
		Account acc = service.returnAccFromId(accId);
		AccountDetails accDetails = service.returnAccDetailsFromAcc(acc);
		
		request.setAttribute("trackKey", tracks);
		request.setAttribute("accDetailsKey", accDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CheckOutPages/checkOut.jsp");
		dispatcher.forward(request, response);
		
	}

}
