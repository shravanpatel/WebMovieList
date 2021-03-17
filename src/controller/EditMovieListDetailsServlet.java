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
 * Servlet implementation class EditMovieListDetailsServlet
 */
@WebServlet("/EditMovieListDetailsServlet")
public class EditMovieListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieListDetailsHelper dao = new MovieListDetailsHelper();
		MovieHelper mh = new MovieHelper();
		TheaterHelper th = new TheaterHelper();

		Integer tempId = Integer.parseInt(request.getParameter("id"));
		MovieListDetails movieListToUpdate = dao.searchForMovieListDetailsById(tempId);

		String newListName = request.getParameter("listName");


		String theaterName = request.getParameter("shopperName");
		Theater newTheater = th.findShopper(theaterName);


		try {
			String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
			List<Movie> selectedMoviesInList = new ArrayList<Movie>();

			for (int i = 0; i < selectedMovies.length; i++) {
				Movie movie = mh.searchForMovieById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(movie);

			}
			movieListToUpdate.setListOfMovies(selectedMoviesInList);
		} catch (NullPointerException ex) {
			List<Movie> selectedMoviesInList = new ArrayList<Movie>();
			movieListToUpdate.setListOfMovies(selectedMoviesInList);
		}

		movieListToUpdate.setListName(newListName);
		movieListToUpdate.setTheater(newTheater);

		dao.updateList(movieListToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
