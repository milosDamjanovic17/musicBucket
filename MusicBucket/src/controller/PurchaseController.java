package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountDetails;
import model.Tracks;
import model.TransactionReport;
import service.PurchaseService;

/**
 * Servlet implementation class PurchaseController
 */
@WebServlet(description = "kontroler za regulisanje finalne kupovine proizvoda", urlPatterns = { "/PurchaseController" })
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PurchaseService service = new PurchaseService();
		
		String accDetailsId = request.getParameter("accDetailsId");
		String trackId = request.getParameter("trackId");
		
		System.out.println(accDetailsId);
		System.out.println(trackId);
		
		
		AccountDetails accDetails = service.returnAccDetailsFromId(accDetailsId);
		Tracks track = service.returnTrackFromId(trackId);
		
		if(accDetails.getBalance() >= track.getPrice()) {
			
			boolean purchase = service.purchaseMethod(track, accDetails);
			if(purchase) {
				service.saveTransaction(accDetails, track);
				response.sendRedirect("CheckOutPages/purchaseCompleted.jsp");
			}else {
				response.sendRedirect("TrackSearchPages/trackSearchSaveTransactionFail.jsp");
			}
			
		}else {
			response.sendRedirect("CheckOutPages/insufficientBalance.jsp");
		}
		
		
		
	}

}
