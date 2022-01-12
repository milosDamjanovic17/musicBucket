package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Account;

public class LoginDAO {

	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public Account returnAccFromLoginInput(String username, String password) {

		Session session = sf.openSession();
			session.beginTransaction();
			
			Account accLocal = null;
			
			try {
				
				String hql = "from Account where username = :usernameInput and password = :passwordInput";
				Query query = session.createQuery(hql);
					query.setParameter("usernameInput", username);
					query.setParameter("passwordInput", password);
					
				accLocal = (Account)query.getSingleResult();	
				System.out.println("postoji ovaj account....");
				session.getTransaction().commit();
				return accLocal;
			} catch (NoResultException nre) {
				System.out.println("Usao sam u noResultException...");
				System.out.println("ne postji account...");
				return null;
			} finally {
				session.close();
			}
			
	}

}
