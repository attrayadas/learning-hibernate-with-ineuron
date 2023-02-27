package in.ineuron.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordAppUsingList {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			// Using list() to retrieve the records
			Query<Employee> query = session.createQuery("FROM in.ineuron.model.Employee");
			List<Employee> employees = query.list();
			employees.forEach(employee -> System.out.println(employee));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}

// We don't need getters and setters in case of mapping using Annotations. 
// Hibernate internally uses Reflection API and it binds the value from ResultSet to private properties of the model.