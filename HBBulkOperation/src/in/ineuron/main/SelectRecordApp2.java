package in.ineuron.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp2 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			Query query = session.createQuery("SELECT ename, esalary FROM in.ineuron.model.Employee2 WHERE eno<=:id");
			query.setParameter("id", 3);
			List<Object[]> list = query.getResultList();
			System.out.println("NAME" + "\t" + "SALARY");
			list.forEach(row -> {
				for (Object obj : row)
					System.out.print(obj + "\t");
				System.out.println();
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
