package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Tracks;

public class AddTracksDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public boolean checkIfTrackExistsInDb(String artist, String title) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				String hql = "from Tracks where artist = :artistInput and title = :titleInput";
				Query query = session.createQuery(hql);
					query.setParameter("artistInput", artist);
					query.setParameter("titleInput", title);
				
				Tracks track = (Tracks)query.getSingleResult();
				session.getTransaction().commit();
				System.out.println("ova pesma vec postoji....");
				return true;
			} catch (NoResultException nre) {
				System.out.println("usao u NO RESULT EXCEPTION..........");
				System.out.println("pesma ne postoji.......");
				return false;
			} catch (Exception e) {
				System.out.println("nesto je interno puklo");
				e.printStackTrace();
				session.getTransaction().rollback();
				return true;
			} finally {
				session.close();
			}
			
		

	}


	public void uploadTrackInDb(Tracks track) {
		
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				session.persist(track);
				System.out.println("uploading track: " +track.getArtist() +" " +track.getTitle() +" to DB.....");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("nesto je puklo u uploadTrackInDb metodi....");
				e.printStackTrace();
				session.getTransaction().rollback();

			} finally {
				session.close();
			}
			

	}

}
