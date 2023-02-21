package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "empTab")
public class Employee {

	/*
	 * Assigned Generator:
	 * 
	 * @Id
	 * 
	 * @Column(name = "eid")
	 * 
	 * @GenericGenerator(name = "gen1", strategy = "assigned")
	 * 
	 * @GeneratedValue(generator = "gen1") private Integer empId;
	 */

	/*
	 * Increment Generator
	 * 
	 * @Id
	 * 
	 * @Column(name = "eid")
	 * 
	 * @GenericGenerator(name = "gen1", strategy = "increment")
	 * 
	 * @GeneratedValue(generator = "gen1") private Integer empId;
	 */

	@Id
	@Column(name = "eid")
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")
	private Integer empId;

	@Column(name = "ename", length = 20)
	private String empName;

	@Column(name = "esal")
	private Double empSal;

	static {
		System.out.println("Employee.class is loading...");
	}

	public Employee() {
		System.out.println("Zero parameter consturctor is used by Hibernate....");
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
		System.out.println("Employee.setEmpId()");
	}

	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Employee.setEmpName()");
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
		System.out.println("Employee.setEmpSal()");
		System.out.println();
	}

	public Double getEmpSal() {
		System.out.println("Employee.getEmpSal()" + empSal);
		System.out.println();
		return empSal;
	}

	public Integer getEmpId() {
		System.out.println("Employee.getEmpId()" + empId);
		return empId;
	}

	public String getEmpName() {
		System.out.println("Employee.getEmpName()" + empName);
		return empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}
