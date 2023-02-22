package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();

		try {
			policy = session.get(InsurancePolicy.class, 1L);

			if (policy == null) {
				System.out.println("Record not found...");
			} else {
				System.out.println("Record found and displayed...");
				System.out.println(policy);
				transaction = session.beginTransaction();
				policy.setTenure(9);
				session.update(policy);

				policy.setTenure(30);
				session.update(policy);

				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object updated...");

			} else {
				transaction.rollback();
				System.out.println("object not updated...");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
