package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieListDetails;

/**
 * Servlet implementation class MovieListNavigationServlet
 */
@WebServlet("/movieListNavigationServlet")
public class MovieListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllMovieListsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				MovieListDetails movieListToDelete = dao.searchForMovieListDetailsById(tempId);
				dao.deleteList(movieListToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllMovieListsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				MovieListDetails movieListToEdit = dao.searchForMovieListDetailsById(tempId);
				request.setAttribute("movieListToEdit", movieListToEdit);
				MovieHelper daoForMovies = new MovieHelper();
				
				request.setAttribute("allMovies", daoForMovies.showAllMovies());
							
				if(daoForMovies.showAllMovies().isEmpty()){
						request.setAttribute("allMovies", " ");
				}
				getServletContext().getRequestDispatcher("/edit-movie-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllMovieListsServlet").forward(request, response);
			} 
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addMoviesToListServlet").forward(request, response);
		}
	}

}
