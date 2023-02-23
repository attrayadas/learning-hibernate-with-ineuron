package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class LoadTestApp {

	public static void main(String[] args) {
		Session session = null;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();

		try {
			policy = session.get(InsurancePolicy.class, 3L);
			if (policy != null) {
				System.out.println("Record found and displayed...");
				System.out.println(policy);
			} else {
				System.out.println("Record not found...");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
