package in.ineuron.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Project;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		/*
		 * try {
		 * 
		 * //Create criteriaBuilder object CriteriaBuilder builder =
		 * session.getCriteriaBuilder();
		 * 
		 * //Creating a criteriaQuery object CriteriaQuery<Project> cQuery =
		 * builder.createQuery(Project.class);
		 * 
		 * //Creating a root object to specify the Entity class name Root<Project> root
		 * = cQuery.from(Project.class);
		 * 
		 * //adding the root object to Criteria Query object cQuery.select(root);
		 * 
		 * //Preparing a query having criteria query object Query<Project> query =
		 * session.createQuery(cQuery);
		 * 
		 * //Executing the JPA QBC logic List<Project> list = query.getResultList();
		 * 
		 * //processing the result list.forEach(System.out::println);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 */

		try {

			// Create criteriaBuilder object
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Creating a criteriaQuery object
			CriteriaQuery<Project> cQuery = builder.createQuery(Project.class);

			// Creating a root object to specify the Entity class name
			Root<Project> root = cQuery.from(Project.class);

			// adding the root object to Criteria Query object
			cQuery.select(root);

			// Setting up the parameter
			ParameterExpression<Long> param1 = builder.parameter(Long.class);
			ParameterExpression<Long> param2 = builder.parameter(Long.class);

			// Adding up the condition
			Predicate p1 = builder.ge(root.get("pid"), param1);
			Predicate p2 = builder.le(root.get("pid"), param2);

			Predicate p3 = builder.and(p1, p2);
			cQuery.where(p3); // where projId>= ? and projId<=?

			// Creating a order clause
			Order order = builder.desc(root.get("projName"));
			cQuery.orderBy(order);// where proId>= ? and projId<=? orderby projName DESC

			// Preparing a query having criteria query object
			Query<Project> query = session.createQuery(cQuery);

			// setting up the parameters for projId
			query.setParameter(param1, 10L);
			query.setParameter(param2, 20L);

			// Executing the JPA QBC logic
			List<Project> list = query.getResultList();

			// processing the result
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
