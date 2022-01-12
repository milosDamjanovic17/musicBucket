package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Account;
import model.AccountDetails;

public class AddBalanceDAO {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Account returnAccFromId(String id) {
		
		Session session = sf.openSession();	
			session.beginTransaction();
			
			try {
				
				String hql = "from Account where accId = :idInput";
				Query query = session.createQuery(hql);
					query.setParameter("idInput", Integer.parseInt(id));
					
					Account accLocal = (Account)query.getSingleResult();
				
					System.out.println("preuzimam acc sa id: " +accLocal.getAccId());
					session.getTransaction().commit();
				return accLocal;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnAccFromId metodi.....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}

	public boolean addBalance(Account acc, Double amountDouble) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				Account accPersist = session.get(Account.class, acc.getAccId());
				String hql = "from AccountDetails where account = :accPersist";
				Query query = session.createQuery(hql);
					query.setParameter("accPersist", accPersist);
					
				AccountDetails accDetailsLocal = (AccountDetails)query.getSingleResult();
					
					if(accDetailsLocal.getBalance() != null) {
						accDetailsLocal.setBalance(accDetailsLocal.getBalance() + amountDouble);
					}else {
						accDetailsLocal.setBalance(amountDouble);
					}
				
				session.update(accDetailsLocal);
				System.out.println("Transfering money to account....");
				session.getTransaction().commit();
				
				return true;
			} catch (Exception e) {
				System.out.println("pukla addBalance metoda.......");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}

}
