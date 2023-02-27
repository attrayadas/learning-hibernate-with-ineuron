package in.ineuron.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class SelectRecordApp3 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			Query query = session.createQuery("SELECT ename FROM in.ineuron.model.Employee2 WHERE eno=:id");
			int id = 3;
			query.setParameter("id", id);
			List<String> list = query.getResultList();
			if (!list.isEmpty()) {
				String ename = list.get(0);
				System.out.println("ename is: " + ename);
			} else {
				System.out.println("Record not found for the id: " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
