package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Employee employee=null;
		int id=36;

		try {
			if(session!=null) 
				employee = session.load(Employee.class, id);
			
			System.out.println(employee);
			

		} catch (HibernateException e) {
			System.out.println("Employee not found for the given id: "+id);
		} 

	}

}
