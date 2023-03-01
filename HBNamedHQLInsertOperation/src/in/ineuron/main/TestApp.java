package in.ineuron.main;

import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		InsurancePolicyDao dao = null;
		dao = new InsurancePolicyDaoImpl();
		String result = dao.transferPremiumPolicies(25);
		System.out.println(result);
		HibernateUtil.closeSessionFactory();
	}

}
