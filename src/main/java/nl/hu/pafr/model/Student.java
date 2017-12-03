package nl.hu.pafr.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private String name;
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_group_id", nullable = false)
	private StudentGroup studentGroup;

	public Student() {
	};

	public Student(String name, String number, String email, StudentGroup studentGroup) {
		super();
		this.number = number;
		this.name = name;
		this.email = email;
		this.setStudentGroup(studentGroup);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name + ", email=" + email + "]";
	}

}