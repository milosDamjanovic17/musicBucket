package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Tracks;

public class TrackSearchDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public List<Tracks> trackSearchList(String artist, String title, String bpm, String genre, String label,
			String year) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				String hql = "from Tracks" +" where 1=1";
				
				if(artist != null && !artist.equals("")) {
					hql += " and artist like :artistInput";
				}
				
				if(title != null && !title.equals("")) {
					hql += " and title like :titleInput";
				}
				
				if(bpm != null && !bpm.equals("")) {
					hql += " and bpm like :bpmInput";
				}
				
				if(genre != null && !genre.equals("")) {
					hql += " and genre like :genreInput";
				}
				
				if(label != null && !label.equals("")) {
					hql += " and label like :labelInput";
				}
				
				if(year != null && !year.equals("")) {
					hql += " and year like :yearInput";
				}
				
				// -------- SETOVANJE PARAMETARA ----------------------------
				
				Query query = session.createQuery(hql);
					
				if(artist != null && !artist.equals("")) {
					query.setParameter("artistInput", "%" +artist +"%");
				}
				
				if(title != null && !title.equals("")) {
					query.setParameter("titleInput", "%" +title +"%");
				}
				
				if(bpm != null && !bpm.equals("")) {
					query.setParameter("bpmInput", "%" +bpm +"%");
				}
				
				if(genre != null && !genre.equals("")) {
					query.setParameter("genreInput", "%" +genre +"%");
				}
				
				if(label != null && !label.equals("")) {
					query.setParameter("labelInput", "%" +label +"%");
				}
				
				if(year != null && !year.equals("")) {
					query.setParameter("yearInput", "%" +year +"%");
				}
					
					
				
				List<Tracks> returnList = (List<Tracks>) query.getResultList();
				
				System.out.println("Retrieving searchList, list has: " +returnList.size() +" track/s");
				session.getTransaction().commit();
				return returnList;
			} catch (Exception e) {
				System.out.println("nesto je puklo u trackSearchList metodi....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			}finally {
				session.close();
			}
		
	}

}
