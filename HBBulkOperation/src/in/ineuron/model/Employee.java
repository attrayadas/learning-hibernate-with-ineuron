//Using Annotations for Mapping

package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Employee.class file is loading...");
	}

	public Employee() {
		System.out.println("Employee Object is instantiated...");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eno;

	@Column
	private String ename;

	@Column
	private String eaddr;

	@Column
	private Integer esalary;

	@Override
	public String toString() {
		System.out.println("Employee.toString()");
		return "Employee [eno=" + eno + ", ename=" + ename + ", eaddr=" + eaddr + ", esalary=" + esalary + "]";
	}

}
