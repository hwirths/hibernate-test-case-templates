package org.hibernate.bugs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh16961Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		/*
		 * Step one : Create an entry for both the port and the device
		 * table. The device entry gets associated to the port entry.
		 */
		Coordinate coordinate = new Coordinate();
		Port port = new Port();
		Device device = new Device();

		coordinate.setSlot_number(1);
		coordinate.setPort_number(1);
		port.setCoordinate(coordinate);
		port.setConnection_id(1);
		
		entityManager.persist(port);
		
		device.setPort(port);
		
		entityManager.persist(device);
		
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		/*
		 * Step two : Request the first entry from the device table.
		 */
		entityManager.getTransaction().begin();
		
		device = entityManager
				.createQuery("select d from Device d", Device.class)
				.setMaxResults(1)
				.getSingleResult();
		
		assertNotNull(device);
		assertNotNull(device.getPort());
		assertEquals(device.getPort().getConnection_id(), 1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
