package nl.hu.pafr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class StudentDaoJpaImpl extends AbstractDaoJpaImpl implements StudentDao {
	private EntityManager em = null;
	public StudentDaoJpaImpl(EntityManager em) {
		this.em = em;
	}
	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		return (List<Student>) em.createQuery("from Student").getResultList();
	}


	public Student get(int id) {
		return em.find(Student.class, id);
	}

	public void update(Student student) {
		em.persist(student);
	}

	public void insert(Student student) {
		em.persist(student);
	}

	public void delete(Student student) {
		em.remove(student);
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
	@Override
	public List<Student> getByGroup(StudentGroup studentGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
