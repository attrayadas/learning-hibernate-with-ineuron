package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Account;
import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Account account = new Account();
			account.setAccNo("IN0185");
			account.setAccName("sachin");
			account.setAccType("savings");

			Employee employee = new Employee();
			employee.setAccount(account);
			employee.setEaddress("Bengaluru");
			employee.setEname("sachin");
			employee.setEsal(45000.0f);

			session.save(employee);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved....");
			} else {
				transaction.rollback();
				System.out.println("object not saved...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}