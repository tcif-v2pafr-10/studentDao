package nl.hu.pafr.dao.memory;

import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class DataStore {
	// list is working as a database
	List<Student> students = new ArrayList<>();
	// list is working as a database
	List<StudentGroup> studentGroups = new ArrayList<>();
	public List<Student> getStudents() {
		return students;
	}
	public List<StudentGroup> getStudentGroups() {
		return studentGroups;
	}

}
