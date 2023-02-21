package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectInfo projectInfo;

	@Column(name = "pname", length = 20)
	private String programmerName;

	@Column(name = "depNo")
	private Integer deptNo;

	@Column(name = "projName", length = 20)
	private String projectName;

	public ProgrammerProjectInfo() {
	}

	public ProgrammerProjectInfo(ProjectInfo projectInfo, String programmerName, Integer deptNo, String projectName) {
		this.projectInfo = projectInfo;
		this.programmerName = programmerName;
		this.deptNo = deptNo;
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [programmerName=" + programmerName + ", deptNo=" + deptNo + ", projectName="
				+ projectName + "]";
	}

}
