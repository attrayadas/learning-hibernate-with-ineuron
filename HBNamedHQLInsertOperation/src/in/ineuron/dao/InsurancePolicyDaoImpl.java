package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

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

			Query query = session.getNamedQuery("HQL_INSERT_TRANSFER_POLICIES");
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
