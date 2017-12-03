/**
 * 
 */
package nl.hu.pafr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.model.StudentGroup;

/**
 * @author berend.wilkens
 *
 */
public class StudentGroupDaoJpaImpl extends AbstractDaoJpaImpl<StudentGroup> implements StudentGroupDao {

	public StudentGroupDaoJpaImpl(EntityManager entityManager) {
		super(entityManager);
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
