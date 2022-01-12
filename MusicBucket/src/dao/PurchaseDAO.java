package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.AccountDetails;
import model.Tracks;
import model.TransactionReport;

public class PurchaseDAO {

	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public AccountDetails returnAccDetailsFromId(String accDetailsId) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				AccountDetails accDetails = session.get(AccountDetails.class, Integer.parseInt(accDetailsId));
				
				System.out.println("preuzimam accDetails.....");
				session.getTransaction().commit();
				return accDetails;
			} catch (Exception e) {
				System.out.println("nesto je puklo u returnAccDetailsFromId metodi.....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}
		
	}

	public Tracks returnTrackFromId(String trackId) {
		
		Session session = sf.openSession();
			session.beginTransaction();
		
		try {
			
			Tracks track = session.get(Tracks.class, Integer.parseInt(trackId));
			
			System.out.println("preuzimam pesmu.....");
			session.getTransaction().commit();
			return track;
		} catch (Exception e) {
			System.out.println("nesto je puklo u returnTrackFromId metodi.....");
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean purchaseMethod(Tracks track, AccountDetails accDetails) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				accDetails.setBalance(accDetails.getBalance() - track.getPrice());
				
				session.update(accDetails);
				session.getTransaction().commit();
				System.out.println("KUPOVINA ZAVRSENA....");
				return true;
				
			} catch (Exception e) {
				System.out.println("pukao purchaseMethod...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}

	public void saveTransaction(AccountDetails accDetails, Tracks track) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			TransactionReport tr = new TransactionReport();
			
			try {
				
				tr.setAccDetails(accDetails);
				tr.setTrack(track);
				tr.setDate(new Date());
				
				session.persist(tr);
				session.getTransaction().commit();
				System.out.println("transakcija sacuvana.......");
				
			} catch (Exception e) {
				System.out.println("pukao saveTransaction....");
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		
	}

}
