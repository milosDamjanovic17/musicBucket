package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tracks;
import service.TrackSearchService;

/**
 * Servlet implementation class TrackSearchController
 */
@WebServlet(description = "kontroler za regulisanje pretrage pesama", urlPatterns = { "/TrackSearchController" })
public class TrackSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TrackSearchService service = new TrackSearchService();
		
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String bpm = request.getParameter("bpm");
		String genre = request.getParameter("genre");
		String label = request.getParameter("label");
		String year = request.getParameter("year");
		
		
		List<Tracks> trackSearchList = service.trackSearchList(artist, title, bpm, genre, label, year);
		
			if(trackSearchList != null) {
				
				trackSearchList.forEach((x -> {
					System.out.println("Artist: " +x.getArtist());
					System.out.println("Title: " +x.getTitle());
					System.out.println("Price: " +x.getPrice());
					}));
				
				request.setAttribute("trackListKey", trackSearchList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("TrackSearchPages/trackSearchResults.jsp");
				dispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("TrackSearchPages/trackSearchFail.jsp");
			}
		
	}

}
