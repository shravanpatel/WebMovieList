
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "movie_list_details")
public @Data class MovieListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_id")
	private int id;
	@Column(name = "list_name")
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "theater_id")
	private Theater theater;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "movies_on_list", joinColumns = {
			@JoinColumn(name = "list_id", referencedColumnName = "list_id") }, inverseJoinColumns = {
					@JoinColumn(name = "movie_id", referencedColumnName = "id", unique = true) })
	private List<Movie> listOfMovies;

	public MovieListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieListDetails(int id, String listName, Theater theater, List<Movie> listOfMovies) {
		super();
		this.id = id;
		this.listName = listName;
		this.theater = theater;
		this.listOfMovies = listOfMovies;
	}

	public MovieListDetails(String listName, Theater theater, List<Movie> listOfMovies) {
		super();
		this.listName = listName;
		this.theater = theater;
		this.listOfMovies = listOfMovies;
	}

	public MovieListDetails(String listName, Theater theater) {
		super();
		this.listName = listName;
		this.theater = theater;
	}
}
