package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();
		try {
			policy = session.get(InsurancePolicy.class, 1L); // gets from DB and put it in L1-cache
			System.out.println("1st: " + policy);

			System.in.read();

			policy = session.get(InsurancePolicy.class, 1L); // gets from L1-cache
			System.out.println("2nd: " + policy);
			System.out.println("=========================");

			System.in.read();

			session.evict(policy); // remove policy object from L1-cache

			System.in.read();

			policy = session.get(InsurancePolicy.class, 1L); // gets from DB and put it in L1-cache
			System.out.println("3rd: " + policy);

			System.in.read();

			policy = session.get(InsurancePolicy.class, 1L); // gets from L1-cache
			System.out.println("4th: " + policy);
			System.out.println("=========================");

			System.in.read();

			session.clear(); // remove all object from L1-cache

			System.in.read();

			policy = session.get(InsurancePolicy.class, 1L); // gets from DB and put it in L1-cache
			System.out.println("5th: " + policy);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);

		}
	}

}
//Output: 
//Hibernate: 
//    select
//        insurancep0_.policyId as policyid1_0_0_,
//        insurancep0_.company as company2_0_0_,
//        insurancep0_.policyName as policyna3_0_0_,
//        insurancep0_.policyType as policyty4_0_0_,
//        insurancep0_.tenure as tenure5_0_0_ 
//    from
//        InsurancePolicy insurancep0_ 
//    where
//        insurancep0_.policyId=?
//1st: InsurancePolicy [policyId=1, policyName=Jeevan Anand, policyType=quater, company=HDFC Ergo, tenure=30]
//
//2nd: InsurancePolicy [policyId=1, policyName=Jeevan Anand, policyType=quater, company=HDFC Ergo, tenure=30]
//=========================
//
//Hibernate: 
//    select
//        insurancep0_.policyId as policyid1_0_0_,
//        insurancep0_.company as company2_0_0_,
//        insurancep0_.policyName as policyna3_0_0_,
//        insurancep0_.policyType as policyty4_0_0_,
//        insurancep0_.tenure as tenure5_0_0_ 
//    from
//        InsurancePolicy insurancep0_ 
//    where
//        insurancep0_.policyId=?
//3rd: InsurancePolicy [policyId=1, policyName=Jeevan Anand, policyType=quater, company=HDFC Ergo, tenure=30]
//4th: InsurancePolicy [policyId=1, policyName=Jeevan Anand, policyType=quater, company=HDFC Ergo, tenure=30]
//=========================
//
//Hibernate: 
//    select
//        insurancep0_.policyId as policyid1_0_0_,
//        insurancep0_.company as company2_0_0_,
//        insurancep0_.policyName as policyna3_0_0_,
//        insurancep0_.policyType as policyty4_0_0_,
//        insurancep0_.tenure as tenure5_0_0_ 
//    from
//        InsurancePolicy insurancep0_ 
//    where
//        insurancep0_.policyId=?
//5th: InsurancePolicy [policyId=1, policyName=Jeevan Anand, policyType=quater, company=HDFC Ergo, tenure=30]
