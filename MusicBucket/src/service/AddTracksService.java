package service;

import dao.AddTracksDAO;
import model.Tracks;

public class AddTracksService {

	AddTracksDAO dao = new AddTracksDAO();
	
	
	
	public boolean checkIfTrackExistsInDb(String artist, String title) {

		return dao.checkIfTrackExistsInDb(artist, title);
	}


	public void uploadTrackInDb(Tracks track) {
		
		dao.uploadTrackInDb(track);
	}

}
