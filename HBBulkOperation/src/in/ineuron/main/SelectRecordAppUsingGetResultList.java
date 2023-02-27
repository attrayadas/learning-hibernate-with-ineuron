package in.ineuron.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordAppUsingGetResultList {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			// Using getResultList() to retrieve the records
			Query<Employee> query = session.createQuery("FROM in.ineuron.model.Employee WHERE eno>=:id1 AND eno<=:id2");
			query.setParameter("id1", 2);
			query.setParameter("id2", 4);
			List<Employee> empRecords = query.getResultList();
			// empRecords.forEach(emp -> System.out.println(emp));
			empRecords.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
