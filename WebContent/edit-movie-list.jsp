<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Movie List</title>
</head>
<body>
	<form action="editMovieListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${movieListToEdit.id}">
		List name: <input type="text" name="movieListName"
			value="${movieListToEdit.listName}"><br /> Theater name: <input
			type="text" name="theaterName"
			value="${movieListToEdit.theater.theaterName}"><br />
		Available movies:<br /> <select name="allMoviesToAdd" multiple
			size="6">
			<c:forEach items="${requestScope.allMovies}" var="currentMovie">
				<option value="${currentMovie.id}">${currentMovie.title} -
					${currentMovie.director}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit list and add movies">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>