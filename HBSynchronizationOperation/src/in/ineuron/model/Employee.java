package in.ineuron.model;

public class Employee {

	private Integer empId;

	private String empName;

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
