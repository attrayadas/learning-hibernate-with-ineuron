package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
	
	@Id
	private String bid;
	private String bname;
	private String blocation;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBlocation() {
		return blocation;
	}

	public void setBlocation(String blocation) {
		this.blocation = blocation;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bname=" + bname + ", blocation=" + blocation + "]";
	}

}
