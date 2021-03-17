package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MovieListDetails;

public class MovieListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebMovieList");

	public void insertNewListDetails(MovieListDetails toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public List<MovieListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<MovieListDetails> allDetails = em.createQuery("SELECT d FROM MovieListDetails d").getResultList();

		return allDetails;
	}

	public void deleteList(MovieListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieListDetails> typedQuery = em.createQuery("SELECT d FROM MovieListDetails d WHERE d.id = :selectedId",
				MovieListDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		typedQuery.setMaxResults(1);

		MovieListDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public MovieListDetails searchForMovieListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MovieListDetails found = em.find(MovieListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(MovieListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
