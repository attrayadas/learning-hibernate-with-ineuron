package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class VersionInsertionTest {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;

		session = HibernateUtil.getSession();
		MobileCustomer customer = new MobileCustomer();
		customer.setCname("Attraya");
		customer.setMobileNo(999999999);
		customer.setCallerTune("KGF-2");

		try {
			transaction = session.beginTransaction();
			idValue = (Integer) session.save(customer);
			System.out.println("Generated id value is: " + idValue);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object is saved...");
			} else {
				transaction.rollback();
				System.out.println("Object is not saved...");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
