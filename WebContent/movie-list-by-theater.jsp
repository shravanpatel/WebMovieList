<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Lists</title>
</head>
<body>
	<form method="post" action="movieListNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allMovieLists}" var="currentMovieList">
				<tr>
					<td><input type="radio" name="id" value="${currentMovieList.id}"></td>
					<td><h2>${currentMovieList.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Theater: ${currentMovieList.theater.theaterName}</td>
				</tr>
				<c:forEach var="listMovie" items="${currentMovieList.listOfMovies}">
					<tr>
						<td></td>
						<td colspan="3">${listMovie.title} - ${listMovie.actors}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	<button type="button" onclick="location.href='addMoviesToListServlet';">
		Create a new movie list </button>
	
</body>
</html>