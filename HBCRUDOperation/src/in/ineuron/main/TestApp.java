/*
 * 1. This main class is meant for understanding. Its not industry standard. Possibly industry standard is StandardApp.java 
 */
package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class TestApp {

	public static void main(String[] args) {

		// Step 1. Creating a configuration object
		Configuration cfg = new Configuration();

		// Step 2. configure hibernate.cfg.xml file to Configuration object
		cfg.configure();

		// Step 3. Create SessionFactory object
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// Step 4. Get the session object from sessionFactory
		Session session = sessionFactory.openSession();

		// Step 5. Begin the Transaction within a session
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(16);
		employee.setEmpName("Krishanu");
		employee.setEmpSalary(3678.8);

		// Step 6. Perform operations
		Serializable save = session.save(employee);
		System.out.println(save);

		// Step7. Performing Transaction operations
		transaction.commit();

		// Step8. Close the session
		session.close();
	}

}
