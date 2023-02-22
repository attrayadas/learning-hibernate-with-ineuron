package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCacheTest3 {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy1 = null;
		InsurancePolicy policy2 = null;

		session = HibernateUtil.getSession();

		try {
			policy1 = session.get(InsurancePolicy.class, 1L); // hit db and put it in L1-cache
			System.out.println(policy1);

			policy2 = session.get(InsurancePolicy.class, 1L); // get from L1-cache and assign same reference
			System.out.println(policy2);

			System.in.read();

			System.out.println(policy1.hashCode() + "::" + policy2.hashCode()); // both are pointing to same reference

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
