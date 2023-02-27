package in.ineuron.main;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee2;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp4 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			Query<Employee2> query = session.createQuery("FROM in.ineuron.model.Employee2 WHERE eno=:id");
			int id = 3;
			query.setParameter("id", id);

//			Using null check:
//			Employee2 employee = query.uniqueResult();
//			if(employee!=null) {
//				System.out.println(employee);
//			} else {
//				System.out.println("Record not found for the given id: "+id);
//			}

//			Here null checking is internal:
			Optional<Employee2> optional = query.uniqueResultOptional();
			if (optional.isPresent()) {
				Employee2 employee2 = optional.get();
				System.out.println(employee2);
			} else {
				System.out.println("Record not found for the given id: " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
