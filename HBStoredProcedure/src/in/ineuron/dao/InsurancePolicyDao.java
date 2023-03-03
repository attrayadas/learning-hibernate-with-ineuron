package in.ineuron.dao;

import java.util.List;

import in.ineuron.model.InsurancePolicy;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPoliciesByTenure(int start, int end);
	public String[] getPolicyById(int id);
}
