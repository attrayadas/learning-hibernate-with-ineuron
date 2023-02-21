package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class DBRowToEntityApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Employee employee = null;

		try {
			employee = session.get(Employee.class, 19);
			if (employee != null) {
				System.out.println("Before any modification: " + employee);
				System.in.read();
				session.refresh(employee);
				System.out.println("After modification in the DB Table: " + employee);
			} else {
				System.out.println("Record not avaialble...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
