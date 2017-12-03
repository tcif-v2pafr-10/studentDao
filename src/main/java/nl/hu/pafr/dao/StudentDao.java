package nl.hu.pafr.dao;

import nl.hu.pafr.model.Student;

public interface StudentDao extends GenericDao<Student> {
	public Student getByNumber(String string);
}
