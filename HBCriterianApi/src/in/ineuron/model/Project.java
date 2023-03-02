package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long pid;

	private String projName;
	private String company;
	private String location;
	private Integer teamSize;
	private float cost;

	public Project() {
		System.out.println("Used by Hibernae:: " + this.getClass());
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projName=" + projName + ", company=" + company + ", location=" + location
				+ ", teamSize=" + teamSize + ", cost=" + cost + "]";
	}
}
