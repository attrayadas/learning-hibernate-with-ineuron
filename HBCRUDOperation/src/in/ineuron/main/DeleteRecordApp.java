/*
 * 3. This is industry standard. It uses a Utility class
 */

package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				int id = 7;
				Employee employee = session.get(Employee.class, id);
				System.out.println(employee);
				if (employee!=null) {
					session.delete(employee);
					flag = true;
				}else {
					System.out.println("Record not available for id: "+id+" for deletion...");
					return;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag=false;
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object deleted successfully...");

			} else {
				transaction.rollback();
				System.out.println("Object failed to delete...");
			}
			HibernateUtil.closeSession(session);
		}

	}

}
