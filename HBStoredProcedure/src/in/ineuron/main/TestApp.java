package in.ineuron.main;

import java.util.List;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		InsurancePolicyDao dao = null;
		dao = new InsurancePolicyDaoImpl();

		List<InsurancePolicy> list = dao.getPoliciesByTenure(25, 30);
		System.out.println(list.size());
		list.forEach(System.out::println);

		System.out.println();

		int id = 100;
		String[] result = dao.getPolicyById(id);
		if (result[0] != null)
			System.out.println(result[0] + "-----" + result[1] + "---" + result[2]);
		else
			System.out.println("Record not found for the id :: " + id);
		HibernateUtil.closeSessionFactory();
	}
}
