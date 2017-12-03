package nl.hu.pafr.dao;

import nl.hu.pafr.model.StudentGroup;

public interface StudentGroupDao extends GenericDao<StudentGroup> {
	public StudentGroup getByCode(String code);
}
