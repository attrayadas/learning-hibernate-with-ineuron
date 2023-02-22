package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SecondLevelCacheTestApp {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();

		try {
			policy = session.get(InsurancePolicy.class, 1L);// get from DB keep in L2 and L1 cache
			System.out.println("1:: " + policy);

			policy = session.get(InsurancePolicy.class, 1L);// get from L1 cache
			System.out.println("2:: " + policy);

			session.evict(policy);// remove from L1 cache

			System.out.println();

			policy = session.get(InsurancePolicy.class, 1L);// get from L2 cache and keep it in L1 cache
			System.out.println("3:: " + policy);

			System.out.println("--------------");
			session.clear(); // removes all the objects from L1 cache

			try {
				Thread.sleep(20000);// 20seconds idle time for the application, so remove from L2 cache
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			policy = session.get(InsurancePolicy.class, 1L);// hit the db and get the record keep in L2 and L1 cache
			System.out.println("4:: " + policy);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
