// Using XML for Mapping

package in.ineuron.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Employee.class file is loading...");
	}

	public Employee() {
		System.out.println("Employee Object is instantiated...");
	}

	private Integer eno;

	private String ename;

	private String eaddr;

	private Integer esalary;

	public Integer getEno() {
		System.out.println("Employee2.getEno()");
		return eno;
	}

	public void setEno(Integer eno) {
		System.out.println("Employee2.setEno()");
		this.eno = eno;
	}

	public String getEname() {
		System.out.println("Employee2.getEname()");
		return ename;
	}

	public void setEname(String ename) {
		System.out.println("Employee2.setEname()");
		this.ename = ename;
	}

	public String getEaddr() {
		System.out.println("Employee2.getEaddr()");
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		System.out.println("Employee2.setEaddr()");
		this.eaddr = eaddr;
	}

	public Integer getEsalary() {
		System.out.println("Employee2.getEsalary()");
		return esalary;
	}

	public void setEsalary(Integer esalary) {
		System.out.println("Employee2.setEsalary()");
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		System.out.println("Employee.toString()");
		return "Employee [eno=" + eno + ", ename=" + ename + ", eaddr=" + eaddr + ", esalary=" + esalary + "]";
	}

}
