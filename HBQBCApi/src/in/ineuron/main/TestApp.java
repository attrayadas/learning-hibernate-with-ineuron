package in.ineuron.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Project;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			// Create criteriaBuilder object
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Creating a criteriaQuery object
			CriteriaQuery<Object[]> cQuery = builder.createQuery(Object[].class);

			// Creating a root object to specify the Entity class name
			Root<Project> root = cQuery.from(Project.class);

			// adding the root object to Criteria Query object
			cQuery.multiselect(root.get("pid"), root.get("projName"), root.get("company"));// select
																							// pid,projName,company from
																							// Project

			Predicate p1 = builder.equal(root.get("location"), "hyd");
			cQuery.where(p1);// select pid,projName,compnay from Project where location = 'hyd'

			// Preparing a query having criteria query object
			Query<Object[]> query = session.createQuery(cQuery);

			// Executing the JPA QBC logic
			List<Object[]> list = query.getResultList();// select pid,projName,company from Project where location =
														// 'hyd'

			// processing the result
			list.forEach(row -> {
				for (Object obj : row) {
					System.out.print(obj + "\t");
				}
				System.out.println();
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
