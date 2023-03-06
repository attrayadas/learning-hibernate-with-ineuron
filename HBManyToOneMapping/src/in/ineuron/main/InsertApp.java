package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Branch;
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

			Branch branch = new Branch();
			branch.setBid("B-111");
			branch.setBname("CS");
			branch.setBlocation("Bengaluru");

			Student s1 = new Student("sachin", "MI", branch);
			Student s2 = new Student("dhoni", "CSK", branch);
			Student s3 = new Student("kohli", "RCB", branch);

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
