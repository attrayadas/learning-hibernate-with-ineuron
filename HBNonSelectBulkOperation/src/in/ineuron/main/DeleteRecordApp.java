package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM in.ineuron.model.Employee WHERE eno<= :id");
			query.setParameter("id", 4);
			count = query.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted are: " + count);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
