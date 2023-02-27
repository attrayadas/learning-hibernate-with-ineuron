package in.ineuron.main;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee2;
import in.ineuron.util.HibernateUtil;

public class SelectRecordAppUsingIterateAndXML {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			// Using iterate() to retrieve the records
			Query query = session.createQuery("FROM in.ineuron.model.Employee2");
			Iterator<Employee2> itr = query.iterate();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}

// If we use XML approach, setter and getter methods are mandatory