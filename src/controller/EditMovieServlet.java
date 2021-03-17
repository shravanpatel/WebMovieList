package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/editMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieHelper dao = new MovieHelper();
		
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String director = request.getParameter("director");
		String producer = request.getParameter("producer");
		String actors = request.getParameter("actors");
		LocalDate releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Movie movieToUpdate = dao.searchForMovieById(tempId);
		movieToUpdate.setTitle(title);
		movieToUpdate.setGenre(genre);
		movieToUpdate.setDirector(director);
		movieToUpdate.setProducer(producer);
		movieToUpdate.setActors(actors);
		movieToUpdate.setReleaseDate(releaseDate);
				
		dao.updateMovie(movieToUpdate);

		getServletContext().getRequestDispatcher("/viewAllMoviesServlet").forward(request, response);
	}

}
