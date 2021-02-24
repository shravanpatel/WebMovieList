import java.util.List;
import java.util.Scanner;

import controller.MovieHelper;
import model.Movie;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static MovieHelper mh = new MovieHelper();

	private static void addMovie() {
		System.out.print("Enter a movie title: ");
		String title = in.nextLine();
		System.out.print("Enter a genre: ");
		String genre = in.nextLine();
		System.out.print("Enter a director: ");
		String director = in.nextLine();
		System.out.print("Enter a producer: ");
		String producer = in.nextLine();
		System.out.print("Enter actors in it: ");
		String actors = in.nextLine();

		Movie toAdd = new Movie(title, genre, director, producer, actors);
		mh.insertMovie(toAdd);
		System.out.println("Movie successfully added");
	}

	private static void deleteMovie() {
		System.out.print("Enter a movie title: ");
		String title = in.nextLine();

		Movie toDelete = new Movie(title);
		mh.deleteMovie(toDelete);
		System.out.println("Movie successfully deleted");
	}

	private static void editMovie() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Title");
		System.out.println("2 : Search by Director");
		System.out.print("Your selection: ");
		int searchBy = in.nextInt();
		in.nextLine();

		List<Movie> foundMovies;
		if (searchBy == 1) {
			System.out.print("Enter a movie title: ");
			String movieName = in.nextLine();
			foundMovies = mh.searchForMovieByTitle(movieName);
		} else {
			System.out.print("Enter a director name: ");
			String directorName = in.nextLine();
			foundMovies = mh.searchForMovieByDirector(directorName);
		}
		System.out.println("--------------------------------------");

		if (!foundMovies.isEmpty()) {
			System.out.println("Found Result");
			int idToEdit = 0;
			for (Movie l : foundMovies) {
				System.out.println(l.toString());
				idToEdit = l.getId();
			}

			Movie toEdit = mh.searchForMovieById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getDirector());
			System.out.println("--------------------------------------");
			System.out.println("1 : Update Title");
			System.out.println("2 : Update Genre");
			System.out.println("3 : Update Director");
			System.out.println("4 : Update Producer");
			System.out.println("5 : Update Actors");
			System.out.print("Your selection: ");

			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Title: ");
				String newStore = in.nextLine();
				toEdit.setTitle(newStore);
				System.out.println("Movie title successfully updated");
			} else if (update == 2) {
				System.out.print("New Genre: ");
				String newItem = in.nextLine();
				toEdit.setGenre(newItem);
				System.out.println("Movie genre successfully updated");
			} else if (update == 3) {
				System.out.print("New Director: ");
				String newItem = in.nextLine();
				toEdit.setDirector(newItem);
				System.out.println("Movie director successfully updated");
			} else if (update == 4) {
				System.out.print("New Producer: ");
				String newItem = in.nextLine();
				toEdit.setProducer(newItem);
				System.out.println("Movie producer successfully updated");
			} else if (update == 5) {
				System.out.print("New Actors: ");
				String newItem = in.nextLine();
				toEdit.setActors(newItem);
				System.out.println("Movie actors successfully updated");
			}
			mh.updateMovie(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to movie list console! ---");
		while (goAgain) {
			System.out.println("--------------------------------------");
			System.out.println("*  Select any option:");
			System.out.println("*  1 -- Add a movie");
			System.out.println("*  2 -- Edit a movie info");
			System.out.println("*  3 -- Delete a movie");
			System.out.println("*  4 -- View the movie list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			System.out.println("--------------------------------------");

			if (selection == 1) {
				addMovie();
			} else if (selection == 2) {
				editMovie();
			} else if (selection == 3) {
				deleteMovie();
			} else if (selection == 4) {
				viewTheList();
			} else {
				mh.cleanUp();
				System.out.println("Goodbye!");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() {
		List<Movie> allItems = mh.showAllMovies();
		System.out.println("--------------------------------------");
		System.out.println("Data Retrived.. \n");
		for (Movie singleItem : allItems) {
			System.out.println(singleItem.returnMovieDetails());
		}
	}

}
