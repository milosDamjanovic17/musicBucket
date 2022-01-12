package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Account;
import model.AccountDetails;

public class AccountDetailsDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public Account returnAccountFromId(String id) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from Account where accId = :idInput";
				Query query = session.createQuery(hql);
					query.setParameter("idInput", Integer.parseInt(id));
					
				Account acc = (Account)query.getSingleResult();
				System.out.println("pronadjen user....");
				
				session.getTransaction().commit();
				return acc;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnAccountFromId metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}
	}


	public AccountDetails returnAccDetailsObjectFromAccount(Account acc) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				String hql = "from AccountDetails where account = :accFromDb";
				Query query = session.createQuery(hql);
				query.setParameter("accFromDb", acc);
				
				AccountDetails details = (AccountDetails) query.getSingleResult();
				
				
				session.getTransaction().commit();
				return details;
			} catch (Exception e) {
				System.out.println("nesto je puklo u returnAccDetails metodi......");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}
		
	}


	public boolean updateAccountDetails(String name, String djName, String description, String url, String genre,
			AccountDetails accDetailsObject) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				AccountDetails accDetailsPersist = session.get(AccountDetails.class, accDetailsObject.getIdAccDetails());
					accDetailsPersist.setName(name);
					accDetailsPersist.setDjName(djName);
					accDetailsPersist.setDescription(description);
					accDetailsPersist.setUrl(url);
					accDetailsPersist.setPreferedGenre(genre);
					
				session.update(accDetailsPersist);
				System.out.println("updating" +accDetailsPersist.getAccount().getUsername() +" AccountDetils.....");
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("nesto je puklo u updateAcc....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}

	}


}
