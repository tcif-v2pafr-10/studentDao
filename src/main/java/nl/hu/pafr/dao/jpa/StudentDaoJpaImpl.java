package nl.hu.pafr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.model.Student;

public class StudentDaoJpaImpl extends AbstractDaoJpaImpl<Student> implements StudentDao {

	public StudentDaoJpaImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Student getByNumber(String number) {
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) em
				.createQuery("from Student where number=" + number).getResultList();
		if (!students.isEmpty()) {
			return students.get(0);
		}
		return null;
	}
}
