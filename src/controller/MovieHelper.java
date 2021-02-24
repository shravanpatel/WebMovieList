package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Movie;

public class MovieHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebMovieList");

	public void insertMovie(Movie toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteMovie(Movie toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em.createQuery("SELECT i FROM Movie i WHERE i.title = :selectedTitle",
				Movie.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setMaxResults(1);

		Movie result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Movie> showAllMovies() {
		EntityManager em = emfactory.createEntityManager();
		List<Movie> allItems = em.createQuery("SELECT i FROM Movie i").getResultList();
		return allItems;
	}

	public List<Movie> searchForMovieByTitle(String titleName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em.createQuery("SELECT i FROM Movie i WHERE i.title = :selectedTitle",
				Movie.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<Movie> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Movie> searchForMovieByDirector(String directorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em
				.createQuery("SELECT i FROM Movie i WHERE i.director = :selectedDirector", Movie.class);
		typedQuery.setParameter("selectedDirector", directorName);
		List<Movie> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Movie> searchForMovieByActor(String actorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em
				.createQuery("SELECT i FROM Movie i WHERE i.actor LIKE '%selectedActor%'", Movie.class);
		typedQuery.setParameter("selectedActor", actorName);
		List<Movie> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Movie> searchForMovieByGenre(String genreSelected) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em
				.createQuery("SELECT i FROM Movie i WHERE i.genre LIKE '%selectedGenre%'", Movie.class);
		typedQuery.setParameter("selectedGenre", genreSelected);
		List<Movie> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public Movie searchForMovieById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Movie found = em.find(Movie.class, idToEdit);
		em.close();
		return found;
	}

	public void updateMovie(Movie toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}
}
