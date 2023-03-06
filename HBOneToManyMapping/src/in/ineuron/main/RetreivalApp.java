package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Department;
import in.ineuron.util.HibernateUtil;

public class RetreivalApp {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Department department = session.get(Department.class, "IPL-16");
			System.out.println(department);

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

//Output:
//	Department [deptId=IPL-16, deptName=Cricket, employees=[Employee [eid=4, ename=sachin, salary=2455.0, eaddress=MI], Employee [eid=2, ename=dhoni, salary=2555.0, eaddress=CSK], Employee [eid=3, ename=kohli, salary=5555.0, eaddress=RCB], Employee [eid=1, ename=smriti, salary=1555.0, eaddress=RCB]]]