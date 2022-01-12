package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Tracks;

public class CheckOutDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Tracks returnTrackFromId(String idTrack) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				Tracks track = session.get(Tracks.class, Integer.parseInt(idTrack));
				
				System.out.println("preuzimam pesmu : " +track.getArtist() +" " +track.getTitle());
				
				session.getTransaction().commit();
				return track;
			} catch (Exception e) {
				System.out.println("nesto je puklo u returnTrackFromId metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}
	
	
}
