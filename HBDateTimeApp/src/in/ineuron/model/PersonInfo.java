package in.ineuron.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20)
	private String pname;

	@Column(length = 20)
	private String paddress;

	private LocalDate dob;

	private LocalDateTime dom;

	private LocalTime doj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getDom() {
		return dom;
	}

	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}

	public LocalTime getDoj() {
		return doj;
	}

	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", pname=" + pname + ", paddress=" + paddress + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}

}
