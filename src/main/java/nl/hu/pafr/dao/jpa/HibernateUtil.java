package nl.hu.pafr.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static String orclcfg = "nl.hu.ict.jpa.oracle";
	private static String mysqlcfg = "nl.hu.ict.jpa.mysql";
	private static boolean mysql = true;
	private static String dbcfg = mysqlcfg;
	private static final EntityManagerFactory entityManagerFactory;

	// entityManagerFactory =
	// Persistence.createEntityManagerFactory("nl.hu.ict.jpa.oracle" );

	static {
		try {
			if (!mysql)
				dbcfg = orclcfg;

			entityManagerFactory = Persistence
					.createEntityManagerFactory(dbcfg);

		} catch (Throwable th) {
			System.err.println("Initial EntityManagerFactory creation failed"
					+ th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}