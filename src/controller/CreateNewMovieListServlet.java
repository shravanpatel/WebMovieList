package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Movie;
import model.MovieListDetails;
import model.Theater;

/**
 * Servlet implementation class CreateNewMovieListServlet
 */
@WebServlet("/createNewMovieListServlet")
public class CreateNewMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewMovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieHelper mh = new MovieHelper();
		String listName = request.getParameter("listName");
		String theaterName = request.getParameter("theaterName");

		String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
		List<Movie> selectedMoviesInList = new ArrayList<Movie>();

		for (int i = 0; i < selectedMovies.length; i++) {
			Movie movie = mh.searchForMovieById(Integer.parseInt(selectedMovies[i]));
			selectedMoviesInList.add(movie);
		}

		Theater theater = new Theater(theaterName);
		MovieListDetails md = new MovieListDetails(listName, theater);
		md.setListOfMovies(selectedMoviesInList);
		MovieListDetailsHelper mlh = new MovieListDetailsHelper();
		mlh.insertNewListDetails(md);

		getServletContext().getRequestDispatcher("/viewAllMovieListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
