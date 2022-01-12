package service;

import dao.PurchaseDAO;
import model.AccountDetails;
import model.Tracks;

public class PurchaseService {

	PurchaseDAO dao = new PurchaseDAO();
	
	
	public AccountDetails returnAccDetailsFromId(String accDetailsId) {
		
		return dao.returnAccDetailsFromId(accDetailsId);
	}


	public Tracks returnTrackFromId(String trackId) {
		
		return dao.returnTrackFromId(trackId);
	}


	public boolean purchaseMethod(Tracks track, AccountDetails accDetails) {
		
		return dao.purchaseMethod(track, accDetails);
	}


	public void saveTransaction(AccountDetails accDetails, Tracks track) {
		
		dao.saveTransaction(accDetails, track);
	}

}
