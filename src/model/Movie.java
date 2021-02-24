package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "movies")
public @Data class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title") 
	private String title;
	@Column(name = "genre")
	private String genre;
	@Column(name = "director")
	private String director;
	@Column(name = "producer")
	private String producer;
	@Column(name = "actors")
	private String actors;

	public Movie() {
		super();
	}

	public Movie(String title, String genre, String director, String producer, String actors) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.producer = producer;
		this.actors = actors;
	}

	public Movie(String title) {
		super();
		this.title = title;
	}

	public String returnMovieDetails() {
		return title + ", directed by " + director + " starring " + actors;
	}
}
