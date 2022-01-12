package service;

import java.util.List;

import dao.TrackSearchDAO;
import model.Tracks;

public class TrackSearchService {

	TrackSearchDAO dao = new TrackSearchDAO();
	
	public List<Tracks> trackSearchList(String artist, String title, String bpm, String genre, String label,
			String year) {
		
		return dao.trackSearchList(artist, title, bpm, genre, label, year);
	}

}
