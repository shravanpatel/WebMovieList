package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieListDetails;

/**
 * Servlet implementation class ViewAllMovieListsServlet
 */
@WebServlet("/viewAllMovieListsServlet")
public class ViewAllMovieListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllMovieListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieListDetailsHelper mlh = new MovieListDetailsHelper();
		List<MovieListDetails> abc = mlh.getLists();
		request.setAttribute("allMovieLists", abc);
		
		if(abc.isEmpty()){
				request.setAttribute("allMovieLists", " ");
		}

		getServletContext().getRequestDispatcher("/movie-list-by-theater.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
