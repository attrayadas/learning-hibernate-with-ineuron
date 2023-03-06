package in.ineuron.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Department;
import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class TestApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Employee e1 = new Employee("sachin", 2455.f, "MI");
			Employee e2 = new Employee("dhoni", 2555.f, "CSK");
			Employee e3 = new Employee("kohli", 5555.f, "RCB");
			Employee e4 = new Employee("smriti", 1555.f, "RCB");

			Set<Employee> set = new HashSet<Employee>();
			set.add(e1);
			set.add(e2);
			set.add(e3);
			set.add(e4);

			Department dept = new Department();
			dept.setDeptId("IPL-16");
			dept.setDeptName("Cricket");
			dept.setEmployees(set);

			session.save(dept);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved....");
			} else {
				transaction.rollback();
				System.out.println("object not saved...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
