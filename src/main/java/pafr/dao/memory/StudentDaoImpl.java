package pafr.dao.memory;

import java.util.List;

import pafr.dao.StudentDao;
import pafr.model.Student;
import pafr.model.StudentGroup;

public class StudentDaoImpl implements StudentDao {
	private DataStore dataStore;

	public StudentDaoImpl() {
	}

	public StudentDaoImpl(DataStore dataStore) {
		super();
		this.dataStore = dataStore;
	}


	public void delete(Student student) {
		Student s = get(student.getId());
		if (s != null) {
			dataStore.getStudents().remove(s);
			System.out.println("Student: number " + student.getId() + ", deleted from database");
		}
	}

	// retrive list of students from the database
	public List<Student> getAll() {
		return dataStore.getStudents();
	}

	public Student get(int id) {
		for (Student s : dataStore.getStudents()) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	public void update(Student student) {
		Student s = get(student.getId());
		if (s != null) {
			s.setName(student.getName());
		}
	}

	public void insert(Student student) {
		if (get(student.getId()) == null) {
			dataStore.getStudents().add(student);
		} else {
			System.out.println("Student already exists.");
		}
	}

	public List<Student> getStudentsByGroup(StudentGroup group) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentByNumber(String number) {
		for (Student s : dataStore.getStudents()) {
			System.out.println(s + " "+ number);
			if (s.getNumber().equals(number)) {
				return s;
			}
		}
		return null;

	}

}
