package in.ineuron.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.model.Project;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		/**
		 * try { Criteria criteria = session.createCriteria(Project.class);
		 * List<Project> list = criteria.list(); list.forEach(System.out::println);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 **/

		/**
		 * try { Criteria criteria = session.createCriteria(Project.class);
		 * 
		 * PropertyProjection p1 = Projections.property("teamSize"); PropertyProjection
		 * p2 = Projections.property("location"); PropertyProjection p3 =
		 * Projections.property("projName");
		 * 
		 * ProjectionList plist = Projections.projectionList(); plist.add(p3);
		 * plist.add(p2); plist.add(p1);
		 * 
		 * criteria.setProjection(plist);
		 * 
		 * Criterion cond1 = Restrictions.ge("teamSize", 10); Criterion cond2 =
		 * Restrictions.le("teamSize", 20);
		 * 
		 * criteria.add(cond1); criteria.add(cond2);
		 * 
		 * Order order1 = Order.asc("location"); Order order2 = Order.desc("projName");
		 * 
		 * criteria.addOrder(order1); criteria.addOrder(order2);
		 * 
		 * List<Object[]> list = criteria.list();
		 * System.out.println("ProjectName\tLocation\tTeamsize"); list.forEach(row -> {
		 * for (Object obj : row) { System.out.print(obj + "\t"); }
		 * System.out.println(); });
		 * 
		 * } catch (Exception e) {
		 * 
		 * } finally { HibernateUtil.closeSession(session);
		 * HibernateUtil.closeSessionFactory(); }
		 **/

//		Pagination:
		try {
			Criteria criteria = session.createCriteria(Project.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(2);
			List<Project> list = criteria.list();
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
