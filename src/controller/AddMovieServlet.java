package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet("/addMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String director = request.getParameter("director");
		String producer = request.getParameter("producer");
		String actors = request.getParameter("actors");
		
		Movie movie = new Movie(title, genre, director, producer, actors);
		MovieHelper dao = new MovieHelper();
		dao.insertMovie(movie);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
}
