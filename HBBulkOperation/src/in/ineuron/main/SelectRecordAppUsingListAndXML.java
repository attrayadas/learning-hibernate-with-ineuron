package in.ineuron.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee2;
import in.ineuron.util.HibernateUtil;

public class SelectRecordAppUsingListAndXML {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			// Using list() to retrieve the records
			Query<Employee2> query = session.createQuery("FROM in.ineuron.model.Employee2");
			List<Employee2> employees = query.list();
			employees.forEach(employee -> System.out.println(employee));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}

// If we use XML approach, setter and getter methods are mandatory