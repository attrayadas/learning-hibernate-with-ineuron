package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "pid")
	private Integer pid;

	@Column(name = "pgmId")
	private Integer pgmid;

	public ProjectInfo() {
	}

	public ProjectInfo(Integer pid, Integer pgmid) {
		this.pid = pid;
		this.pgmid = pgmid;
	}

	@Override
	public String toString() {
		return "ProjectInfo [pid=" + pid + ", pgmid=" + pgmid + "]";
	}

}
