package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	private static final String HQL_TRANSFER_QUERY = "INSERT INTO in.ineuron.model.PremiumInsurancePolicy(policyId,policyName,policyType,company,tenure) SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure FROM in.ineuron.model.InsurancePolicy as i WHERE i.tenure>:tenure";

	@Override
	public String transferPremiumPolicies(int maxTenure) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;
		String msg = null;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery(HQL_TRANSFER_QUERY);
			query.setParameter("tenure", maxTenure);

			count = query.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				msg = "no. of record transferred is: " + count;
			} else {
				transaction.rollback();
				msg = "record not copied/inserted";
			}
			HibernateUtil.closeSession(session);
		}
		return msg;
	}

}
