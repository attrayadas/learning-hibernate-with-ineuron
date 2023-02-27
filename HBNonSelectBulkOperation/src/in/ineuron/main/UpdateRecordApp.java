package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("UPDATE in.ineuron.model.Employee SET esalary=esalary+ :increment WHERE eno<= :id");
			query.setParameter("increment", 3);
			query.setParameter("id", 4);
			count = query.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No. of record updated are: " + count);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
