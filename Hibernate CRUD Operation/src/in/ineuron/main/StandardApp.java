/*
 * 2. This is close to industry standard. However there are some logic which will be repeating for every operation.
 * Hence, we made DemoApp.java which is an industry standard and used in.ineuron.util.HibernateUtil.java for repeated logic.
 */

package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class StandardApp {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;

		cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());

		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setEmpId(19);
		employee.setEmpName("Krishanu");
		employee.setEmpSalary(3678.8);

		try {
			transaction = session.beginTransaction();
			idValue = (Integer) session.save(employee);
			System.out.println("Generated ID value is: " + idValue);
			flag = true;
			System.out.println("id value is: " + employee.getEmpId());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();

		}

	}

}
