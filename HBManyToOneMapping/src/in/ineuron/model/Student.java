package in.ineuron.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String address;

	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", branch=" + branch + "]";
	}

	public Student(String sname, String address, Branch branch) {
		this.sname = sname;
		this.address = address;
		this.branch = branch;
	}

	public Student() {
		System.out.println("used by hibernate during De-Serialization...");
	}

}
