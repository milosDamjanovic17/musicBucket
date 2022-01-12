package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Account;
import model.AccountDetails;



public class RegistrationDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();

	@SuppressWarnings("unchecked")
	public Account checkIfUsernameExists(Account acc) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			Account returnAcc = acc;
			
			List<Account> localList = new ArrayList<>();
			
			try {
				
				String hql = "from Account where username = :usernameInput";
				Query query = session.createQuery(hql);
					query.setParameter("usernameInput", acc.getUsername());
					
					localList = (List<Account>) query.getResultList();
					if(localList.isEmpty()) {
						System.out.println("username je unique....");
						session.getTransaction().commit();
						return returnAcc;
					}else {
						System.out.println("vec postoji ovaj username.......");
						session.getTransaction().commit();
						return null;
					}
					
				
			} catch (Exception e) {
				System.out.println("nesto je puklo u checkIfUsernameExists metodi.....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}

	public boolean saveAccountInDB(Account acc) {
		
		AccountDetails accDetails = new AccountDetails();
			accDetails.setAccount(acc);	
		
		Session session = sf.openSession();
			session.beginTransaction();
			

			
			try {
				
				session.persist(acc);
				session.persist(accDetails);
				System.out.println("cuvam account sa username: " +acc.getUsername() +" u DB");
				
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("nesto je puklo pri registrovanju korisnika....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}
	
	


}
