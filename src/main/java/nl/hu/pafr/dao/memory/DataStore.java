package nl.hu.pafr.dao.memory;

import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.model.Student;

public class DataStore {
	// list is working as a database
	List<Student> students = new ArrayList<>();
	public List<Student> getStudents() {
		return students;
	}
}
