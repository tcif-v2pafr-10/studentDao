package nl.hu.pafr.model;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
	private int id;
	private String code;
	private List<Student> students = new ArrayList<Student>();

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
