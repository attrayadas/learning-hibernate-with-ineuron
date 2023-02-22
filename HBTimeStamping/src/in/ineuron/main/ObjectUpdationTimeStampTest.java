package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectUpdationTimeStampTest {

	public static void main(String[] args) {

		Session session = null;
		BankAccount account = null;
		Transaction transaction = null;
		boolean flag = false;

		session = HibernateUtil.getSession();

		try {
			transaction = session.beginTransaction();

			long id = 3L;
			account = session.get(BankAccount.class, id);
			if (account != null) {
				account.setBalance(account.getBalance() + 10000);
				flag = true;
			} else {
				System.out.println("Record not available for modification...");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;

		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
				System.out.println("Account opened   on   :: " + account.getOpeningDate());
				System.out.println("Account modified on   :: " + account.getLastUpdated());
				System.out.println("No of modification is :: " + account.getVersion());

			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}

	}

}
