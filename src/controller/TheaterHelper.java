
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Theater;

public class TheaterHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebMovieList");

	public void insertShopper(Theater toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public List<Theater> showAllShoppers() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Theater> allShoppers = em.createQuery("SELECT t FROM Theater t").getResultList();
		return allShoppers;
	}

	public Theater findShopper(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Theater> typedQuery = em.createQuery("SELECT t FROM Theater t WHERE t.theaterName = :theaterName",
				Theater.class);
		typedQuery.setParameter("theaterName", nameToLookUp);
		Theater foundTheater;
		try {
			foundTheater = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundTheater = new Theater(nameToLookUp);
		}
		em.close();

		return foundTheater;
	}
}
