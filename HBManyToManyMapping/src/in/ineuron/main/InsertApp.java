package in.ineuron.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Course;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Course c1 = new Course("C-111", "Java", 1000);
			Course c2 = new Course("C-222", "JEE", 1500);
			Course c3 = new Course("C-333", "Frameworks", 2000);

			Set<Course> set1 = new HashSet<Course>();
			set1.add(c1);
			set1.add(c2);
			set1.add(c3);

			Set<Course> set2 = new HashSet<Course>();
			set2.add(c3);

			Set<Course> set3 = new HashSet<Course>();
			set3.add(c2);
			set3.add(c3);

			Student s1 = new Student("sachin", "MI", set1);
			Student s2 = new Student("dhoni", "CSK", set2);
			Student s3 = new Student("kohli", "RCB", set3);

			session.save(s1);
			session.save(s2);
			session.save(s3);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Objects saved....");
			} else {
				transaction.rollback();
				System.out.println("objects not saved...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
