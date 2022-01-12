package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tracks;
import service.AddTracksService;
import service.CommonMethodsService;

/**
 * Servlet implementation class AddTracksController
 */
@WebServlet(description = "kontroler za reuglisanje uploada pesama u DB", urlPatterns = { "/AddTracksController" })
public class AddTracksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommonMethodsService common = new CommonMethodsService();
		AddTracksService service = new AddTracksService();
		
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String bpm = request.getParameter("bpm");
		String genre = request.getParameter("genre");
		String label = request.getParameter("label");
		String year = request.getParameter("year");
		String price = request.getParameter("price");
		
		boolean blankInputsCheck = common.blankInputsCheck(artist, title, bpm, genre, label, year, price);
		if(blankInputsCheck) {
			
			boolean priceDoubleCheck = common.isAmountDoubleForPrice(price);
			if(priceDoubleCheck) {
				Double priceInDouble = Double.parseDouble(price);
				
				
				boolean checkIfTrackExistsInDb = service.checkIfTrackExistsInDb(artist, title);
				if(!checkIfTrackExistsInDb) {
					Tracks track = common.setupTrack(artist, title, bpm, genre, label, year, priceInDouble);
					service.uploadTrackInDb(track);
					response.sendRedirect("AccountPages/addTracksAdminSuccess.jsp");
				}else {
					response.sendRedirect("AccountPages/addTracksAdminFailTrackExists.jsp");
				}
				
			}else {
				response.sendRedirect("AccountPages/addTracksAdminPriceFail.jsp");
			}
			
		}else {
			response.sendRedirect("AccountPages/addTracksAdminFail.jsp");
		}
		
		
		
		
		
	}


}
