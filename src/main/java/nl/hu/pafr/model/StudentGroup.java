package nl.hu.pafr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_group")
public class StudentGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@OneToMany(mappedBy = "studentGroup")
	private List<Student> students = new ArrayList<>();

	public StudentGroup() {
	}
	
	public StudentGroup(int id, String code) {
		this.id = id;
		this.code = code;
	}

	public void addStudent(Student student) {
		students.add(student);
		student.setStudentGroup(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", code=" + code + ", students=" + students
				+ "]";
	}
}
