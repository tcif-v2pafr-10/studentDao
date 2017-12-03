package nl.hu.pafr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.model.StudentGroup;

public class StudentGroupDaoJpaImpl extends AbstractDaoJpaImpl implements StudentGroupDao {
	StudentDao studentDao;
	private EntityManager em = null;

	public StudentGroupDaoJpaImpl(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<StudentGroup> getAll() {
		List<StudentGroup> groups = (List<StudentGroup>) em.createQuery("from StudentGroup").getResultList();
		return groups;
	}

	public StudentGroup get(int id) {
		return em.find(StudentGroup.class, id);
	}

	public void update(StudentGroup group) {
		em.persist(group);
	}

	public void insert(StudentGroup group) {
		em.persist(group);
	}

	public void delete(StudentGroup group) {
		em.remove(group);
	}

	@Override
	public StudentGroup getByCode(String code) {
		@SuppressWarnings("unchecked")
		List<StudentGroup> groups = (List<StudentGroup>) em
				.createQuery("from StudentGroup where code=" + code).getResultList();
		if (!groups.isEmpty()) {
			return groups.get(0);
		}
		return null;
	}
}
