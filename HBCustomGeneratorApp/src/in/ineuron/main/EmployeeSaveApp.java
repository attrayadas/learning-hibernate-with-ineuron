package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class EmployeeSaveApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpName("Malinga");
				employee.setEmpSal(43333.56);
				session.save(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object inserted successfully...");
			} else {
				transaction.rollback();
				System.out.println("Object failed to insert...");
			}

			HibernateUtil.closeSession(session);
		}

	}

}
